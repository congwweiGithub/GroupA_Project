package com.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.param.PmsProductParam;
import com.mall.model.response.CommonResult;
import com.mall.service.PmsProductService;

@RequestMapping("/product")
@Controller
public class PmsProductCreateController {

	@Autowired
	private PmsProductService pmsProductService;

	private static final Logger logger = LoggerFactory.getLogger(PmsProductCreateController.class);

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProduct(@RequestBody PmsProductParam param) {

		if (!pmsProductService.productIsExsiting(param.getName())) {
			pmsProductService.createProuduct(param);
			logger.info("Product {} 添加成功.", param.getName());
			return new CommonResult(200, null, "通信成功");

		} else {
			logger.warn("Product {} 添加失败.", param.getName());
			return new CommonResult(201, null, "通信失败");
		}

	}
}
