package com.mall.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mall.model.list.CmsPrefrenceAreaProductRelation;
import com.mall.model.list.CmsSubjectProductRelation;
import com.mall.model.list.PmsMemberPrice;
import com.mall.model.list.PmsProductAttributeValue;
import com.mall.model.list.PmsProductFullReduction;
import com.mall.model.list.PmsProductLadder;
import com.mall.model.list.PmsSkuStock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "pms_product")
public class PmsProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//@Column(name = "画册图片")
	private String albumPics;

	//@Column(name = "图标")
	private String icon;

	//@Column(name = "品牌编号")
	private Long brandId;

	//@Column(name = "品牌名称")
	private String brandName;

	//@Column(name = "删除状态")
	private Integer deleteStatus;

	//@Column(name = "商品描述")
	private String description;

	//@Column(name = "详情")
	private String detailDesc;

	//@Column(name = "产品详情网页内容")
	private String detailHtml;

	//@Column(name = "移动端网页详情")
	private String detailMobileHtml;

	private String detailTitle;

	private Long feightTemplateId;

	//@Column(name = "赠送的成长值")
	private Integer giftGrowth;

	//@Column(name = "赠送的积分")
	private Integer giftPoint;

	//@Column(name = "关键字")
	private String keyWords;

	//@Column(name = "库存预警值")
	private Integer lowStock;

	//@Column(name = "商品名称")
	private String name;

	//@Column(name = "新旧状态")
	private Integer newStatus;

	private String note;

	//@Column(name = "市场价")
	private double originalPrice;

	private String pic;

	//@Column(name = "是否为预告商品")
	private Integer previewStatus;

	private double price;

	private Long productAttributeCategoryId;

	private Long productCategoryId;

	//@Column(name = "商品分类名称")
	private String productCategoryName;

	//@Column(name = "货号")
	private String productSn;

	//@Column(name = "促销结束时间")
	private Timestamp promotionEndTime;

	//@Column(name = "活动限购数量")
	private Integer promotionPerLimit;

	//@Column(name = "促销价格")
	private double promotionPrice;

	//@Column(name = "促销开始时间")
	private Timestamp promotionStartTime;

	//@Column(name = "促销类型")
	private Integer promotionType;

	//@Column(name = "上架状态")
	private Integer publishStatus;

	//@Column(name = "推荐状态")
	private Integer recommandStatus;

	//@Column(name = "销量")
	private Integer sale;

	//@Column(name = "以逗号分割的产品服务")
	private String serviceIds;

	//@Column(name = "排序")
	private Integer sort;

	//@Column(name = "库存")
	private Integer stock;

	//@Column(name = "副标题")
	private String subTitle;

	//@Column(name = "单位")
	private String unit;

	//@Column(name = "限制使用的积分数")
	private Integer usePointLimit;

	//@Column(name = "审核状态")
	private Integer verifyStatus;

	//@Column(name = "商品重量，默认为克")
	private double weight;

	
	//JPA oneToMany Match
	@OneToMany(mappedBy = "pmsProduct")
	private List<CmsPrefrenceAreaProductRelation> cmsPrefrenceAreaProductRelation;

	@OneToMany(mappedBy = "pmsProduct")
	private List<CmsSubjectProductRelation> cmsSubjectProductRelation;
	
	@OneToMany(mappedBy = "pmsProduct")
	private List<PmsMemberPrice> pmsMemberPrice;
	
	@OneToMany(mappedBy = "pmsProduct")
	private List<PmsProductAttributeValue> pmsProductAttributeValue;
	
	@OneToMany(mappedBy = "pmsProduct")
	private List<PmsProductFullReduction> pmsProductFullReduction;
	
	@OneToMany(mappedBy = "pmsProduct")
	 private List<PmsProductLadder> pmsProductLadder;
	
	@OneToMany(mappedBy = "pmsProduct")
	 private List<PmsSkuStock> pmsSkuStock;
	
	
	
	
	
	
	
}