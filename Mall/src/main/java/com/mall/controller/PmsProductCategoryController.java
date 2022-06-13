package com.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/productCategory")
@Controller
@Slf4j
public class PmsProductCategoryController {

	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@ResponseBody
	@GetMapping("/list/withChildren")
	public CommonResult list() {

		ObjectMapper pmsProductCategoryJson = new ObjectMapper();
		try {
			String pmsProductCategoryString = pmsProductCategoryJson
					.writeValueAsString(pmsProductCategoryWithChildrenRepository.findAll());
			log.info("pmsProductCategoryWithChildrenRepository.findAll() 的值: {} ", pmsProductCategoryString);
		} catch (JsonProcessingException e) {
			log.error(null);
			e.printStackTrace();
		}

		return new CommonResult(200, pmsProductCategoryWithChildrenRepository.findAll(), "ok");
	}

}
