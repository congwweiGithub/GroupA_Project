package com.mall.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mall.model.pms.PmsBrand;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsBrandRepository;

@RequestMapping("/brand")
@Controller
public class PmsBrandController {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	// 创建品牌
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createBrand(@RequestBody PmsBrand param) {

		BeanUtils.copyProperties(param, pmsBrandRepository);
		pmsBrandRepository.save(param);
		return new CommonResult(200, null, "Succeed");

	}

	// get商品品牌下拉栏
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public CommonResult listBrand(HttpServletRequest request) {
		// logger.info("get brand request {}", request);

//		Example<PmsBrand> pmsBrandExample = Example.of(PmsBrand);
//		List<PmsBrand> PmsBrandList = pmsBrandRepository.findAll(pmsBrandExample);
//		BeanUtils.copyProperties(PmsBrandList, request);

		// TODO 把数据传到添加商品的品牌选项下拉栏
		// logger.info("get brand repository {}", pmsBrandRepository);
		// logger.info("get copied brand request {}", request);
//			PmsBrand pmsBrand = PmsBrand.builder()//
//					.brandId(request.getParameter("brandId") == null ? null : Long.valueOf(request.getParameter("brandId")))//
//					.brandName(request.getParameter("brandName") == null ? null : String.valueOf(request.getParameter("brandName"))).build();
//			CommonPagePmsProduct cppp = new CommonPagePmsProduct(products, 0, 0, 0l, 0);

		return new CommonResult(200, request, "ok");
	}

}
