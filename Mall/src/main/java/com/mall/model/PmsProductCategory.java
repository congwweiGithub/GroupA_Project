//package com.mall.model;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Table(name = "pms_product_category")
//public class PmsProductCategory {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	private String description;
//	//描述
//
//	private String icon;
//	//图标
//
//	private String keywords;
//	
//	private Integer level;
//	//分类级别：0->1级；1->2级
//
//	private String name;
//	
//	private Integer navStatus;
//	//是否显示在导航栏：0->不显示；1->显示
//
//	private Long parentId;
//	//上级分类的编号：0表示一级分类
//
//	private Integer productCount;
//	
//	private String productUnit;
//	
//	private Integer showStatus;
//	//显示状态：0->不显示；1->显示
//
//	private Integer sort;
//	
//
//	@OneToMany(mappedBy="pmsProductCategory")
//	private List<PmsProductCategoryWithChilderItem> pmsProductCategoryWithChilderItem;
//	
//	
//	//commonresult
////	@ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "children")
////    private PmsProductCategory pmsProductCategory;
//
//	
//	
//
//}
