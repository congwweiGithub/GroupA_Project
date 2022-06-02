//package com.example.demo.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.example.demo.model.PmsProduct;                //此包等model完成后统一改
//import com.example.demo.param.ProductParam;              //此包等model完成后统一改
//import com.example.demo.param.Response;                  //此包参数较多，明天跟朱桑要一下
//import com.example.demo.param.CommonPagePmsProduct;      //此包明天跟朱桑要一下
//import com.example.demo.repository.PmsProductRepository; //明天跟朱桑确认repository中的方法，如果跟我的一样，更换导包
//
//@RequestMapping("/product")
//@Controller
//public class ProductController {  //今天有内容需确认，明天确认后再整合到PmsProductController中，更改相应的类名，并统一命名规则
//	
//	@Autowired
//	private PmsProductRepository pmsProductRepository;
//	
//	@ResponseBody
//	@PostMapping("/create")
//	public Response create(@RequestBody ProductParam productParam) {
//		pmsProductRepository.save(productParam.getPmsProduct());
//		return new Response(0, null, "ok");
//	}
//	
//
//	@ResponseBody
//	@GetMapping("/list")
//	public Response list (HttpServletRequest request) {
//		
//		PmsProduct pmsProduct = PmsProduct.builder()//
//				.brandId(request.getParameter("brandId") == null ? null : Long.valueOf(request.getParameter("brandId")))//
//				.keyWords(request.getParameter("keyword"))//
//				.productCategoryId(request.getParameter("productCategoryId") == null ? null : Long.valueOf(request.getParameter("productCategoryId")))//
//				.publishStatus(request.getParameter("publishStatus") == null ? null : Integer.valueOf(request.getParameter("publishStatus")))//
//				.verifyStatus(request.getParameter("verifyStatus") == null ? null : Integer.valueOf(request.getParameter("verifyStatus")))//
//				.productSn(request.getParameter("productSn")).build();
//		
//		Example<PmsProduct> example = Example.of(pmsProduct);
//		List<PmsProduct> list = pmsProductRepository.findAll(example);
//		//TODO 仕样不清楚 暂时设定为0
//		CommonPagePmsProduct cpp = new CommonPagePmsProduct(list, 0, 0, 0l, 0);
//		return new Response(0, cpp, "ok");
//	}
//}
