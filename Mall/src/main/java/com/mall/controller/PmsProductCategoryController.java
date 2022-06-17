package com.mall.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.pms.PmsProductCategory;
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
		ObjectMapper pmsProductCategoryJson = new ObjectMapper();

		String pmsProductCategory;
		try {
			pmsProductCategory = pmsProductCategoryJson
					.writeValueAsString(pmsProductCategoryWithChildrenRepository.findAll());
			log.info("pmsProductCategoryWithChildrenRepository.findAll() 的值: {} ", pmsProductCategory);
		} catch (JsonProcessingException e) {
			log.info("exception type JsonProcessingException");
			e.printStackTrace();
		}

		return new CommonResult(200, pmsProductCategoryWithChildrenRepository.findAll(), "ok");
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProductCategory(@RequestBody PmsProductCategory param) {

		BeanUtils.copyProperties(param, pmsProductCategoryRepository);

		pmsProductCategoryRepository.savePmsProductCategory(null);

		log.info("ProductCategory " + param.getName() + "添加成功");

		return new CommonResult(200, null, "通信成功");
	}

}
