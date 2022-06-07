package com.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.PmsProduct;
import com.mall.model.param.CommonPagePmsProduct;
import com.mall.model.response.ProductResponse;
import com.mall.repository.PmsProductRepository;

@RequestMapping("/product")
@Controller
public class PmsProductExploreController {
	
	@Autowired
	private PmsProductRepository pmsProductRepository;
			
	@ResponseBody
	@GetMapping("/list")
	public ProductResponse list (HttpServletRequest request) {
		
		PmsProduct pmsProduct = PmsProduct.builder()//
				.brandId(request.getParameter("brandId") == null ? null : Long.valueOf(request.getParameter("brandId")))//
				.keyWords(request.getParameter("keyword"))//
				.productCategoryId(request.getParameter("productCategoryId") == null ? null : Long.valueOf(request.getParameter("productCategoryId")))//
				.publishStatus(request.getParameter("publishStatus") == null ? null : Integer.valueOf(request.getParameter("publishStatus")))//
				.verifyStatus(request.getParameter("verifyStatus") == null ? null : Integer.valueOf(request.getParameter("verifyStatus")))//
				.productSn(request.getParameter("productSn")).build();
		
		Example<PmsProduct> example = Example.of(pmsProduct);
		List<PmsProduct> products = pmsProductRepository.findAll(example);
						
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int pageSize = Integer.valueOf(request.getParameter("pageSize"));
		if(pageSize * pageNum < products.size()) { 
			products = products.subList(pageNum * pageSize -  pageSize, pageNum * pageSize);
		} 
		if(pageNum * pageSize >= products.size() && pageNum * pageSize - pageSize != 0 && products.size() > pageNum * pageSize - pageSize) {
			products = products.subList(pageNum * pageSize -  pageSize, products.size());
		}
		//TODO 式样不清楚 暂时设定为0
		CommonPagePmsProduct cppp = new CommonPagePmsProduct(products, 0, 0, 0l, 0);
		return new ProductResponse(200, cppp, "ok");
	}
}
