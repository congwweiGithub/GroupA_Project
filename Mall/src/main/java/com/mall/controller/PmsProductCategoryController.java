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

		log.info("查询一级分类及其子分类成功");
		return new CommonResult(200, pmsProductCategoryWithChildrenRepository.findAll(), "OK");
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProductCategory(@RequestBody PmsProductCategoryParam param) {

		PmsProductCategory category = new PmsProductCategory();
		PmsProductCategoryWithChildrenItem categoryWithChildren = new PmsProductCategoryWithChildrenItem();
		BeanUtils.copyProperties(param, category);
		BeanUtils.copyProperties(param, categoryWithChildren);
		Long parentId = param.getParentId();

		if (pmsProductCategoryRepository.findByName(category.getName()) == null
				&& pmsProductCategoryWithChildrenRepository.findByName(categoryWithChildren.getName()) == null) {

			if (parentId != 0) {
				PmsProductCategoryWithChildrenItem parent = pmsProductCategoryWithChildrenRepository
						.findById(param.getParentId()).get();
				category.setParent(parent);
				category.setLevel(1);
				pmsProductCategoryRepository.save(category);
			} else {
				categoryWithChildren.setLevel(0);
				pmsProductCategoryWithChildrenRepository.save(categoryWithChildren);
			}

			log.info("ProductCategory 添加成功 name：{}", param.getName());

			return new CommonResult(200, null, "OK");
		} else {
			log.info("ProductCategory 添加失败 name：{}", param.getName());

			return new CommonResult(201, null, "Created");
		}

	}
}
