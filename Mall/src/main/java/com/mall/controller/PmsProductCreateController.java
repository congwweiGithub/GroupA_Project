package com.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.pms.PmsProduct;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductRepository;

@RequestMapping("/product")
@Controller
public class PmsProductCreateController {

	@Autowired
	private PmsProductRepository pmsProductRepository;
	private static final Logger logger = LoggerFactory.getLogger(PmsProductCreateController.class);

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProduct(@RequestBody PmsProduct param) {

		if (!param.getName().isEmpty() && !param.getProductCategoryName().isEmpty()//
				&& !param.getSubTitle().isEmpty()//
				&& !param.getBrandName().isEmpty()) {

			BeanUtils.copyProperties(param, pmsProductRepository);

			pmsProductRepository.save(param);
			logger.info("Product " + param.getName() + "添加成功");
		}
		return new CommonResult(200, null, "通信成功");
	}

}
