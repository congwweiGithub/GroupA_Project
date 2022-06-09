//package com.mall.model.param;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//
//import com.mall.model.PmsProduct;
//import com.mall.model.list.CmsPrefrenceAreaProductRelation;
//import com.mall.model.list.CmsSubjectProductRelation;
//import com.mall.model.list.PmsMemberPrice;
//import com.mall.model.list.PmsProductAttributeValue;
//import com.mall.model.list.PmsProductFullReduction;
//import com.mall.model.list.PmsProductLadder;
//import com.mall.model.list.PmsSkuStock;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class PmsProductParam extends PmsProduct{ //跟PmsProduct几乎一样，此类用于传递参数，PmsProduct用于数据库表格的创建
//
//	//JPA oneToMany Match
//		@OneToMany(mappedBy = "pmsProduct")
//		private List<CmsPrefrenceAreaProductRelation> cmsPrefrenceAreaProductRelation;
//
//		@OneToMany(mappedBy = "pmsProduct")
//		private List<CmsSubjectProductRelation> cmsSubjectProductRelation;
//		
//		@OneToMany(mappedBy = "pmsProduct")
//		private List<PmsMemberPrice> pmsMemberPrice;
//		
//		@OneToMany(mappedBy = "pmsProduct")
//		private List<PmsProductAttributeValue> pmsProductAttributeValue;
//		
//		@OneToMany(mappedBy = "pmsProduct")
//		private List<PmsProductFullReduction> pmsProductFullReduction;
//		
//		@OneToMany(mappedBy = "pmsProduct")
//		 private List<PmsProductLadder> pmsProductLadder;
//		
//		@OneToMany(mappedBy = "pmsProduct")
//		 private List<PmsSkuStock> pmsSkuStock;
//}
