package com.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.PmsProductCategoryWithChildrenItem;
import com.mall.model.param.CommonPmsProductCategory;
import com.mall.model.response.ProductResponse;
import com.mall.repository.PmsProductCategoryWithChildrenRepository;

@RequestMapping("/productCategory")
@Controller
public class PmsProductCategoryController {

	@Autowired
	private PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;
			
//	@ResponseBody
//	@GetMapping("/list/withChildren")
//	public ProductResponse list (HttpServletRequest request) {
//		
//		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildren = PmsProductCategoryWithChildrenItem.builder()//
//				.description(request.getParameter("description"))//
//				.icon(request.getParameter("icon"))//
//				.keywords(request.getParameter("keywords")) //
//				.level(request.getParameter("level")== null ? null : Integer.valueOf(request.getParameter("level"))) //
//				.name(request.getParameter("name")) //
//				.navStatus(request.getParameter("navStatus")== null ? null : Integer.valueOf(request.getParameter("navStatus")))//
//				.productCount(request.getParameter("productCount")== null ? null : Integer.valueOf(request.getParameter("productCount")))//
//				.productUnit(request.getParameter("productUnit")== null ? null : Integer.valueOf(request.getParameter("productUnit")))//
//				.showStatus(request.getParameter("showStatus")== null ? null : Integer.valueOf(request.getParameter("showStatus")))//
//				.sort(request.getParameter("sort")== null ? null : Integer.valueOf(request.getParameter("sort")))//
//				.parentId(request.getParameter("parentId")== null ? null : Long.valueOf(request.getParameter("parentId")))//				
//				.build();
//		
//		Example<PmsProductCategoryWithChildrenItem> example = Example.of(pmsProductCategoryWithChildren);
//		List<PmsProductCategoryWithChildrenItem> productCategoryWihtChildren = pmsProductCategoryRepository.findAll(example);
//	
//		//TODO 式样不清楚 暂时随意设定一个值
//		CommonPmsProductCategory commonPmsProductCategory = new CommonPmsProductCategory(
//				productCategoryWihtChildren,0l,"description","icon", "keywords", 0,"name",
//				0,0,0,0,0,0l);
//		
//		return new ProductResponse(200, commonPmsProductCategory, "ok");
//	}
	
	@ResponseBody
	@GetMapping("/list/withChildren")
	public ProductResponse list (PmsProductCategoryWithChildrenItem pmsproductCategoryWithChildren) {
//		BeanUtils.copyProperties(pmsproductCategoryWithChildren, pmsProductCategoryRepository);
		System.out.println(pmsproductCategoryWithChildren.getChildren());
		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildren = PmsProductCategoryWithChildrenItem.builder()//
			
				.description(pmsproductCategoryWithChildren.getDescription())//
				.icon(pmsproductCategoryWithChildren.getIcon())//
				.keywords(pmsproductCategoryWithChildren.getKeywords()) //
				.level(pmsproductCategoryWithChildren.getLevel()) //
				.name(pmsproductCategoryWithChildren.getName()) //
				.navStatus(pmsproductCategoryWithChildren.getNavStatus())//
				.productCount(pmsproductCategoryWithChildren.getProductCount())//
				.productUnit(pmsproductCategoryWithChildren.getProductUnit())//
				.showStatus(pmsproductCategoryWithChildren.getShowStatus())//
				.sort(pmsproductCategoryWithChildren.getSort())//
				.parentId(pmsproductCategoryWithChildren.getParentId())//				
				.children(pmsproductCategoryWithChildren.getChildren())//
				.build();
		pmsProductCategoryWithChildrenRepository.save(pmsProductCategoryWithChildren);
		PmsProductCategoryWithChildrenItem pmsProductCategoryWithChildrenItem = 
				pmsProductCategoryWithChildrenRepository.findByProductCategoryId(pmsproductCategoryWithChildren.getProductCategoryId());
		
		System.out.println(pmsproductCategoryWithChildren.getChildren());
		
		return new ProductResponse(200, pmsProductCategoryWithChildrenItem, "ok");
	}
}
