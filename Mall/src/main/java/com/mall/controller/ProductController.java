package com.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.controller.UmsAdminController.Response;
import com.mall.model.PmsProduct;
import com.mall.model.response.CommonPage;
import com.mall.model.response.CommonPagePmsProduct;
import com.mall.repository.PmsProductRepository;


@RequestMapping("/product")
@Controller
public class ProductController {  
	
	@Autowired
	private PmsProductRepository pmsProductRepository;
	
//	@ResponseBody
//	@PostMapping("/create")
//	public Response create(@RequestBody ProductParam productParam) {
//		pmsProductRepository.save(productParam.getPmsProduct());
//		return new Response(0, null, "ok");
//	}
	

	@ResponseBody
	@GetMapping("/list")
	public Response list (@RequestParam(name = "brandId", required = false)Long brandId,//
			@RequestParam(name = "keyword", required = false)String keyword,//
			@RequestParam(name = "productCategoryId", required = false)Long productCategoryId,//
			@RequestParam(name = "publishStatus", required = false)Integer publishStatus,//
			@RequestParam(name = "verifyStatus", required = false)Integer verifyStatus,//
			@RequestParam(name = "productSn", required = false)String productSn,//
			@RequestParam(name = "pageNum", required = false, defaultValue = "1")Integer pageNum,//
			@RequestParam(name = "pageSize", required = false, defaultValue = "5")Integer pageSize) {
		
		PmsProduct pmsProduct = PmsProduct.builder()//
				.brandId(brandId)//
				.keyWords(keyword)//
				.productCategoryId(productCategoryId)//
				.publishStatus(publishStatus)//
				.verifyStatus(verifyStatus)//
				.productSn(productSn).build();
		
		Example<PmsProduct> example = Example.of(pmsProduct);
		List<PmsProduct> products = pmsProductRepository.findAll(example);
		
		if(pageSize * pageNum < products.size()) { 
			products = products.subList(pageNum * pageSize -  pageSize, pageNum * pageSize);
		} 
		if(pageNum * pageSize >= products.size() && pageNum * pageSize - pageSize != 0 && products.size() > pageNum * pageSize - pageSize) {
			products = products.subList(pageNum * pageSize -  pageSize, products.size());
		}
		//TODO 式样尚不明确 暂时设定为0
		CommonPage<PmsProduct> commonPage = new CommonPage<>(products, 0, 0, 0l, 0);
		return new Response(200, commonPage, "ok");
	}
}
