package com.mall.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.pms.PmsBrand;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsBrandRepository;
import com.mall.service.PmsBrandService;

@RequestMapping("/brand")
@Controller
public class PmsBrandController {

	@Autowired
	// CommonResultPmsBrand commonResultPmsBrand;
	PmsBrandRepository pmsBrandRepository;
	PmsBrandRepository pmsBrandParam;
	PmsBrandService pmsBrandService;
	//private static final Logger logger = LoggerFactory.getLogger(PmsProductController.class);

	// 创建品牌
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createBrand(@RequestBody PmsBrand param) {

		BeanUtils.copyProperties(param, pmsBrandRepository);
		pmsBrandRepository.save(param);
		return new CommonResult(200, null, "Succeed");

	}

	@ResponseBody
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public CommonResult brandListAll(@RequestParam() Map<String, Object> map) {
		map.put("", pmsBrandService.FindAllBrands());
		
		return new CommonResult(200, map, "ok");
	}

	// TODO 等会再写
	// get商品品牌下拉栏
	// CommonResultPmsBrand
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public CommonResult brandList(@RequestParam("keyword") String keyword, //
			@RequestParam("page_num") Integer page_num, //
			@RequestParam("page_size") Integer page_size) {
				return null;
		
	}
	
//		// logger.info("get brand request {}", request);
//		List<PmsBrand> pmsBrandList = pmsBrandParam.findAll();
//		logger.info("get brand repository {}", pmsBrandParam);
//		// TODO 把数据传到添加商品的品牌选项下拉栏
//		// logger.info("get brand repository {}", pmsBrandRepository);
//		// logger.info("get copied brand request {}", request);
////			PmsBrand pmsBrand = PmsBrand.builder()//
////					.brandId(request.getParameter("brandId") == null ? null : Long.valueOf(request.getParameter("brandId")))//
////					.brandName(request.getParameter("brandName") == null ? null : String.valueOf(request.getParameter("brandName"))).build();
////			CommonPagePmsProduct cppp = new CommonPagePmsProduct(products, 0, 0, 0l, 0);
//		PmsBrandParam pmsBrandParam;
//		
//		//TODO if 页码的if判断
////		if(pageSize * pageNum < products.size()) { 
////			products = products.subList(pageNum * pageSize -  pageSize, pageNum * pageSize);
////		} 
////		if(pageNum * pageSize >= products.size() && pageNum * pageSize - pageSize != 0 && products.size() > pageNum * pageSize - pageSize) {
////			products = products.subList(pageNum * pageSize -  pageSize, products.size());
////		}
//		
//		CommonResultPmsBrand commonResultPmsBrand = new CommonResultPmsBrand<>((pmsBrandList, pageNum, pageSize, total, totalPage));
//		return new CommonResult(200, commonResultPmsBrand, "ok");
//	}

}
