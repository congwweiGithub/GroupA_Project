package com.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.param.PmsProductParam;
import com.mall.model.response.CommonResult;
import com.mall.service.PmsProductService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/product")
@Controller
@Slf4j
public class PmsProductCreateController {

	@Autowired
	private PmsProductService pmsProductService;

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProduct(@RequestBody PmsProductParam param) {

		if (!pmsProductService.productIsExsiting(param.getName())) {
			pmsProductService.createProuduct(param);
			log.info("Product {} 添加成功.", param.getName());
			return new CommonResult(200, null, "OK");

		} else {
			log.warn("Product {} 添加失败.", param.getName());
			return new CommonResult(201, null, "Created");
		}

	}
}
