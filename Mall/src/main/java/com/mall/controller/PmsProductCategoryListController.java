package com.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/productCategory")
@Controller
@Slf4j
public class PmsProductCategoryListController {
	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@ResponseBody
	@GetMapping("/list/{parentId}")
	public CommonResult getProductCategoryList(@RequestParam(name = "pageNum", required = false) Integer pageNum, //
			@RequestParam(name = "pageNum", required = false) Integer pageSize, //
			@RequestParam(name = "pageNum", required = false) Long parentId) {
		log.info("get productCategory list pagenum: {}, pageSize:{}, parentId:{}", pageNum, pageSize, parentId);

		List<PmsProductCategoryWithChildrenItem> pmsProductCategoryWithChildrenItem = pmsProductCategoryWithChildrenRepository
				.findAll();
//TODO  （缺一个类）
		return new CommonResult(200, pmsProductCategoryWithChildrenRepository.findAll(), "ok");

	}
}
