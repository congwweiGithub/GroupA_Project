package com.GroupAMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.GroupAMall.models.PmsProduct;
import com.GroupAMall.response.Responce.Response;
import com.GroupAMall.services.PmsProductService;

@Controller
@RequestMapping("/product")
public class PmsProductController {

	@Autowired
	private PmsProductService pmsProductService;

	// 创建商品
	@ResponseBody
	@PostMapping("/create")
	public Response create(@RequestBody PmsProduct pmsProduct) {
		if (pmsProductService.createProduct(/* Product的参数类型 参数 */) != null) {
			return new Response(201, null, "Created");
		}
		return new Response(200, null, "");

	}

	// 查询商品
	// @GetMapping("/list")

}
