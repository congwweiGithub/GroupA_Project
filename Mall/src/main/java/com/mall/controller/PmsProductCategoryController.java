package com.mall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.pms.PmsProductCategory;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import com.mall.model.response.CommonPmsProductCategory;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

@RequestMapping("/productCategory")
@Controller
public class PmsProductCategoryController {

	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@ResponseBody
	@GetMapping("/list/withChildren")
	public CommonResult list() {

		// TODO
//		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenItem = 
//				pmsProductCategoryWithChildrenRepository.findAllById(20l);

		List<PmsProductCategoryWithChildrenItem> pmsProductCategoryWithChildrenitem = pmsProductCategoryWithChildrenRepository
				.findAll();
		// TODO
//		System.out.println(pmsProductCategoryWithChildrenitem);

		List<CommonPmsProductCategory> testList = new ArrayList<>();
		CommonPmsProductCategory test = new CommonPmsProductCategory();
		BeanUtils.copyProperties(pmsProductCategoryWithChildrenitem, test);
		List<PmsProductCategory> testList1 = new ArrayList<>();
		PmsProductCategory test1 = new PmsProductCategory();
		test1.setIcon("222222");
		testList1.add(test1);
		test.setChildren(testList1);
		testList.add(test);
		return new CommonResult(200, testList, "ok");
	}
}
