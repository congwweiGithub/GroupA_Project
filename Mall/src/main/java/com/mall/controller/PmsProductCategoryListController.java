package com.mall.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.pms.PmsProductCategory;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import com.mall.model.response.CommonPage;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryRepository;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/productCategory")
@Controller
@Slf4j
public class PmsProductCategoryListController {
	@Autowired
	private PmsProductCategoryRepository pmsProductCategoryRepository;

	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@ResponseBody
	@GetMapping("/{id}") // 这个方法现在实现的功能中暂时没用到。
	public CommonResult getProductCategoryListById(@PathVariable Long id) {

		log.info("get productCategory list Id:{}", id);

		List<PmsProductCategory> pmsProductCategory = pmsProductCategoryRepository.findByParentId(id);

		return new CommonResult(200, pmsProductCategory, "通信成功");

	}

	@ResponseBody
	@GetMapping("/list/{parentId}")
	public CommonResult getProductCategoryListByParentId(
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, //
			@RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, //
			@PathVariable Long parentId) {
		log.info("get productCategory list pagenum: {}, pageSize:{}, parentId:{}", pageNum, pageSize, parentId);

		if (parentId == 0) {

			List<PmsProductCategoryWithChildrenItem> pmsProductCategoryWithChildrenItem = pmsProductCategoryWithChildrenRepository
					.findAll();
			Integer total = pmsProductCategoryWithChildrenItem.size();// 总个数
			Integer result = total % pageSize;
			Integer totalPage = (Integer) (result > 0 ? // 总页数 如果取模大于0说明总个数和每页显示个数整除后需要加一页
					total / pageSize + 1 : total / pageSize);

			Integer maxCount = pageSize * pageNum; // 每页中显示的最大序号
			Integer minCount = pageSize * (pageNum - 1);// 每页中的最小序号
			if (maxCount > pmsProductCategoryWithChildrenItem.size()) {
				maxCount = pmsProductCategoryWithChildrenItem.size();
			}
			pmsProductCategoryWithChildrenItem = pmsProductCategoryWithChildrenItem.subList(minCount, maxCount);

			CommonPage<PmsProductCategoryWithChildrenItem> commonPageCategoryWithChildrenItem = new CommonPage<PmsProductCategoryWithChildrenItem>(
					pmsProductCategoryWithChildrenItem, pageNum, pageSize, (long) total, totalPage);
			return new CommonResult(200, commonPageCategoryWithChildrenItem, "通信成功");
		}
		List<PmsProductCategory> pmsProductCategory = pmsProductCategoryRepository.findByParentId(parentId);
		Integer total = pmsProductCategory.size();
		Integer result = total % pageSize;
		Integer totalPage = (Integer) (result > 0 ? total / pageSize + 1 : total / pageSize);
		Integer maxCount = pageSize * pageNum;
		Integer minCount = pageSize * (pageNum - 1);
		if (maxCount > pmsProductCategory.size()) {
			maxCount = pmsProductCategory.size();
		}
		pmsProductCategory = pmsProductCategory.subList(minCount, maxCount);

		CommonPage<PmsProductCategory> commonPageCategory = new CommonPage<PmsProductCategory>(pmsProductCategory,
				pageNum, pageSize, (long) total, totalPage);
		return new CommonResult(200, commonPageCategory, "通信成功");

	}

}
