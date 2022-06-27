package com.mall.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.param.PmsProductCategoryParam;
import com.mall.model.pms.PmsProductCategory;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryRepository;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/productCategory")
@Controller
@Slf4j
public class PmsProductCategoryController {

	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@Autowired
	private PmsProductCategoryRepository pmsProductCategoryRepository;

	@ResponseBody
	@GetMapping("/list/withChildren")
	public CommonResult getProductCategoryWithChildren() {

		return new CommonResult(200, pmsProductCategoryWithChildrenRepository.findAll(), "ok");
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProductCategory(@RequestBody PmsProductCategoryParam param) {

		log.info("商品分类信息: {}", param);

		PmsProductCategory category = new PmsProductCategory();

		BeanUtils.copyProperties(param, category);
		Long parentId = param.getParentId();

		if (pmsProductCategoryRepository.findByName(category.getName()).isEmpty()) {

			if (parentId != 0) {
				PmsProductCategoryWithChildrenItem parent = pmsProductCategoryWithChildrenRepository
						.findById(param.getParentId()).get();
				category.setParent(parent);
				category.setLevel(1);
			} else {
				category.setLevel(0);
			}

			pmsProductCategoryRepository.save(category);

			log.info("ProductCategory " + param.getName() + "添加成功");

			return new CommonResult(200, null, "通信成功");
		} else {
			log.info("ProductCategory " + param.getName() + "添加失败");

			return new CommonResult(201, null, "通信失败");
		}

	}
}
