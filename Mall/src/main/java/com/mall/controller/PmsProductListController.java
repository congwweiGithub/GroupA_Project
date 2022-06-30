package com.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.pms.PmsProduct;
import com.mall.model.response.CommonPage;
import com.mall.model.response.CommonResult;
import com.mall.service.PmsProductService;

@RequestMapping("/product")
@Controller
public class PmsProductListController {

	@Autowired
	private PmsProductService pmsProductService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public CommonResult list(@RequestParam(name = "brandId", required = false) Long brandId, //
			@RequestParam(name = "keyword", required = false) String keyword, //
			@RequestParam(name = "productCategoryId", required = false) Long productCategoryId, //
			@RequestParam(name = "publishStatus", required = false) Integer publishStatus, //
			@RequestParam(name = "verifyStatus", required = false) Integer verifyStatus, //
			@RequestParam(name = "productSn", required = false) String productSn, //
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, //
			@RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {

		CommonPage<PmsProduct> commonPage = pmsProductService.findRequiredProducts(pageNum, pageSize, keyword);

		return new CommonResult(200, commonPage, "ok");
	}
}