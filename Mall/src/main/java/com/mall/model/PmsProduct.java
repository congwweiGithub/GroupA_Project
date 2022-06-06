package com.mall.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PmsProduct implements Serializable{// 跟PmsProduct几乎一样，此类用于传递参数，PmsProduct用于数据库表格的创建

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private int deleteStatus;

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
	private int giftGrowth;

	// 赠送的积分
	private int giftPoint;

	// 关键字
	private String keyWords;

	// 库存预警值
	private int lowStock;

	// 商品名称
	private String name;

	// 新旧状态
	private int newStatus;

	private String note;

	// 市场价
	private double originalPrice;

	private String pic;

	// 是否为预告商品
	private int previewStatus;

	private double price;

	private Long productAttributeCategoryId;

	private Long productCategoryId;

	// 商品分类名称
	private String productCategoryName;

	// 货号
	private String productSn;

	// 促销结束时间
	private Date promotionEndTime;

	// 活动限购数量
	private int promotionPerLimit;

	// 促销价格
	private double promotionPrice;

	// 促销开始时间
	private Date promotionStartTime;

	// 促销类型
	private int promotionType;

	// 上架状态
	private int publishStatus;

	// 推荐状态
	private int recommandStatus;

	// 销量
	private int sale;

	// 以逗号分割的产品服务
	private String serviceIds;

	// 排序
	private int sort;

	// 库存
	private int stock;

	// 副标题
	private String subTitle;

	// 单位
	private String unit;

	// 限制使用的积分数
	private int usePointLimit;

	// 审核状态
	private int verifyStatus;

	// 商品重量，默认为克
	private double weight;

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

}
