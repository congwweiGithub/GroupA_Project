package com.mall.controller;

import java.util.List;
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
import com.mall.model.response.CommonResultPmsBrand;
import com.mall.repository.pms.PmsBrandRepository;
import com.mall.service.PmsBrandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/brand")
@Controller
public class PmsBrandController {

	@Autowired
	PmsBrandRepository pmsBrandRepository;
	@Autowired
	PmsBrandRepository pmsBrandParam;
	@Autowired
	PmsBrandService pmsBrandService;

	// private static final Logger logger =
	// LoggerFactory.getLogger(PmsProductController.class);

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
	public CommonResult brandList(
			@RequestParam(name = "keyword", required = false) String keyword, //
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, //
			@RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize){
		
		log.info("get brand list keyword: {}, pagenum:{}, pageSize:{}", keyword, pageNum, pageSize);
		
		List<PmsBrand> pmsBrand = pmsBrandService.FindAllBrands();
		CommonResultPmsBrand commonResultPmsBrand = new CommonResultPmsBrand(pmsBrand, 1, 5, 0l, 0);
		return new CommonResult(200, commonResultPmsBrand, "ok");

	}
	
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

	// TODO
//	@ResponseBody
//	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
//	public CommonResult brandListAll() {
//		
//		List<PmsBrand> pmsBrand = pmsBrandService.FindAllBrands();
//		
//		return new CommonResult(200, pmsBrand, "ok");
	//}

}
