package com.mall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public CommonResult list() {

		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenItem = pmsProductCategoryWithChildrenRepository
				.findAllById(20l);
		log.info("pmsProductCategoryWithChildrenItem的值：+++++++++{}", pmsProductCategoryWithChildrenItem.toString());

		PmsProductCategory pmsProductCategory = pmsProductCategoryRepository.findAllById(20l);
		log.info("pmsProductCategory的值：+++++++++{}", pmsProductCategory.toString());

		List<PmsProductCategoryWithChildrenItem> testList = new ArrayList<>();
		List<PmsProductCategory> testListChild = new ArrayList<>();
		testListChild.add(pmsProductCategory);
		pmsProductCategoryWithChildrenItem.setChildren(testListChild);
		testList.add(pmsProductCategoryWithChildrenItem);

		return new CommonResult(200, testList, "ok");
	}
}