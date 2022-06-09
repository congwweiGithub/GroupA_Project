package com.mall.model.param;

<<<<<<< Upstream, based on main
import java.util.Date;
import java.util.List;
=======
>>>>>>> 5aabae6 统一项目包目录

<<<<<<< Upstream, based on main
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.mall.model.cms.CmsPrefrenceAreaProductRelation;
import com.mall.model.cms.CmsSubjectProductRelation;
import com.mall.model.pms.PmsMemberPrice;
import com.mall.model.pms.PmsProductAttributeValue;
import com.mall.model.pms.PmsProductFullReduction;
import com.mall.model.pms.PmsProductLadder;
import com.mall.model.pms.PmsSkuStock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmsProductParam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// 画册图片
	private String albumPics;

	// 图标
	private String icon;

	// 品牌编号
	private Long brandId;

	// 品牌名称
	private String brandName;

	// 删除状态
	private Integer deleteStatus;

	// 商品描述
	private String description;

	// 详情
	private String detailDesc;

	// 产品详情网页内容
	private String detailHtml;

	// 移动端网页详情
	private String detailMobileHtml;

	private String detailTitle;

	private Long feightTemplateId;

	// 赠送的成长值
	private Integer giftGrowth;

	// 赠送的积分
	private Integer giftPoint;

	// 关键字
	private String keyWords;

	// 库存预警值
	private Integer lowStock;

	// 商品名称
	private String name;

	// 新旧状态
	private Integer newStatus;

	private String note;

	// 市场价
	private Double originalPrice;

	private String pic;

	// 是否为预告商品
	private Integer previewStatus;

	private Double price;

	private Long productAttributeCategoryId;

	private Long productCategoryId;

	// 商品分类名称
	private String productCategoryName;

	// 货号
	private String productSn;

	// 促销结束时间
	private Date promotionEndTime;

	// 活动限购数量
	private Integer promotionPerLimit;

	// 促销价格
	private Double promotionPrice;

	// 促销开始时间
	private Date promotionStartTime;

	// 促销类型
	private Integer promotionType;

	// 上架状态
	private Integer publishStatus;

	// 推荐状态
	private Integer recommandStatus;

	// 销量
	private Integer sale;

	// 以逗号分割的产品服务
	private String serviceIds;

	// 排序
	private Integer sort;

	// 库存
	private Integer stock;

	// 副标题
	private String subTitle;

	// 单位
	private String unit;

	// 限制使用的积分数
	private Integer usePointLimit;

	// 审核状态
	private Integer verifyStatus;

	// 商品重量，默认为克
	private Double weight;

	// JPA oneToMany Match
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

=======
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mall.model.cms.CmsPrefrenceAreaProductRelation;
import com.mall.model.cms.CmsSubjectProductRelation;
import com.mall.model.pms.PmsMemberPrice;
import com.mall.model.pms.PmsProductAttributeValue;
import com.mall.model.pms.PmsProductFullReduction;
import com.mall.model.pms.PmsProductLadder;
import com.mall.model.pms.PmsSkuStock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "pms_product")
public class PmsProductParam {

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
	
	
	
	
	
	
	
>>>>>>> 5aabae6 统一项目包目录
}