package com.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.PmsProduct;
import com.mall.model.response.CommonPagePmsProduct;
import com.mall.model.response.CommonResult;
import com.mall.repository.PmsProductRepository;

@RequestMapping("/product")
@Controller
public class PmsProductController {

	@Autowired
	private PmsProductRepository pmsProductRepository;
	// private PmsProductLadderRepository pmsProductLadderRepository;
	private static final Logger logger = LoggerFactory.getLogger(PmsProductController.class);

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult createProduct(@RequestBody PmsProduct param) {
		logger.info("接收成功");
		if (!param.getName().isEmpty() && !param.getProductCategoryName().isEmpty()//
				&& !param.getSubTitle().isEmpty()//
				&& !param.getBrandName().isEmpty()) { // 价格类型为Number，判断条件">0"显示报错

			// TODO 测试用
			// @RequestBody List<PmsProductLadder> pmsProductLadder
			// for ()
			// BeanUtils.copyProperties(param.getPmsProductLadder(), param);
			// pmsProductRepository.save(pmsProductLadder);
			// BeanUtils.copyProperties(param.getPmsProductLadder(), param);

			BeanUtils.copyProperties(param, pmsProductRepository);
			pmsProductRepository.save(param);

			logger.info("param的值:{}", param.toString());

			// TODO 测试用
			// logger.info("Ladder的值{}", param.getPmsProductLadder().toString());

			logger.info("Product {} 添加成功", param.getName());
			return new CommonResult(200, null, "Succeed");
		} else {
			logger.warn("Produc {} 添加失败", param.getName());
			return new CommonResult(404, null, "Fail");
		}
	}

	@ResponseBody
	@GetMapping("/list")
	public CommonResult list(HttpServletRequest request) {

		PmsProduct pmsProduct = PmsProduct.builder()//
				.brandId(request.getParameter("brandId") == null ? null : Long.valueOf(request.getParameter("brandId")))//
				.keyWords(request.getParameter("keyword"))//
				.productCategoryId(request.getParameter("productCategoryId") == null ? null
						: Long.valueOf(request.getParameter("productCategoryId")))//
				.publishStatus(request.getParameter("publishStatus") == null ? null
						: Integer.valueOf(request.getParameter("publishStatus")))//
				.verifyStatus(request.getParameter("verifyStatus") == null ? null
						: Integer.valueOf(request.getParameter("verifyStatus")))//
				.productSn(request.getParameter("productSn")).build();

		Example<PmsProduct> example = Example.of(pmsProduct);
		List<PmsProduct> products = pmsProductRepository.findAll(example);

		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int pageSize = Integer.valueOf(request.getParameter("pageSize"));
		if (pageSize * pageNum < products.size()) {
			products = products.subList(pageNum * pageSize - pageSize, pageNum * pageSize);
		}
		if (pageNum * pageSize >= products.size() && pageNum * pageSize - pageSize != 0
				&& products.size() > pageNum * pageSize - pageSize) {
			products = products.subList(pageNum * pageSize - pageSize, products.size());
		}
		// TODO 式样不清楚 暂时设定为0
		CommonPagePmsProduct cppp = new CommonPagePmsProduct(products, 0, 0, 0l, 0);
		return new CommonResult(200, cppp, "ok");
	}

}