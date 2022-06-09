package com.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import com.mall.model.response.CommonPmsProductCategory;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

@RequestMapping("/productCategory")
@Controller
public class PmsProductCategoryController {
	
	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;
	//TODO(COMPARE)
	@ResponseBody
	@GetMapping("/list/withChildren")
	public CommonResult list (HttpServletRequest request) {
		
		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildren = PmsProductCategoryWithChildrenItem.builder()//
				.description(request.getParameter("description"))//
				.icon(request.getParameter("icon"))//
				.keywords(request.getParameter("keywords")) //
				.level(request.getParameter("level")== null ? null : Integer.valueOf(request.getParameter("level"))) //
				.name(request.getParameter("name")) //
				.navStatus(request.getParameter("navStatus")== null ? null : Integer.valueOf(request.getParameter("navStatus")))//
				.productCount(request.getParameter("productCount")== null ? null : Integer.valueOf(request.getParameter("productCount")))//
				.productUnit(request.getParameter("productUnit")== null ? null : Integer.valueOf(request.getParameter("productUnit")))//
				.showStatus(request.getParameter("showStatus")== null ? null : Integer.valueOf(request.getParameter("showStatus")))//
				.sort(request.getParameter("sort")== null ? null : Integer.valueOf(request.getParameter("sort")))//
				.parentId(request.getParameter("parentId")== null ? null : Long.valueOf(request.getParameter("parentId")))//				
				.build();
		
		
		PmsProductCategoryWithChildrenItem productCategoryWihtChildren = (PmsProductCategoryWithChildrenItem) pmsProductCategoryWithChildrenRepository.findAll();
				
		return new CommonResult(200, productCategoryWihtChildren, "ok");
	}

//	@ResponseBody
//	@GetMapping("/list/withChildren")
//	public CommonResult list(PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenItem) {
//
////		BeanUtils.copyProperties(pmsproductCategoryWithChildrenItem, pmsProductCategoryWithChildrenRepository);	
//		//TODO
//		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildren = PmsProductCategoryWithChildrenItem.builder()//
//
//				.description(pmsProductCategoryWithChildrenItem.getDescription())//
//				.icon(pmsProductCategoryWithChildrenItem.getIcon())//
//				.keywords(pmsProductCategoryWithChildrenItem.getKeywords()) //
//				.level(pmsProductCategoryWithChildrenItem.getLevel()) //
//				.name(pmsProductCategoryWithChildrenItem.getName()) //
//				.navStatus(pmsProductCategoryWithChildrenItem.getNavStatus())//
//				.productCount(pmsProductCategoryWithChildrenItem.getProductCount())//
//				.productUnit(pmsProductCategoryWithChildrenItem.getProductUnit())//
//				.showStatus(pmsProductCategoryWithChildrenItem.getShowStatus())//
//				.sort(pmsProductCategoryWithChildrenItem.getSort())//
//				.parentId(pmsProductCategoryWithChildrenItem.getParentId())//
//				.children(pmsProductCategoryWithChildrenItem.getChildren())//
//				.build();
//		pmsProductCategoryWithChildrenRepository.save(pmsProductCategoryWithChildrenItem);
////		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenitem = 
////				pmsProductCategoryWithChildrenRepository.findByProductCategoryId(pmsProductCategoryWithChildren.getProductCategoryId());
//
//		System.out.println(pmsProductCategoryWithChildrenItem.toString());
//
//		return new CommonResult(200, pmsProductCategoryWithChildrenItem, "ok");
//	}
}
