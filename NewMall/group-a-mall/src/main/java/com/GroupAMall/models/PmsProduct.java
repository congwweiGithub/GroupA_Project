package com.GroupAMall.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "product")
@Data
public class PmsProduct {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name ="画册图片")
	private String albumPics;
	

	private String icon;
	

	private Long brandId;
	
	@Column(name ="品牌名称")
	private String brandName;
	
	@Column(name ="删除状态")
	private int deleteStatus;

	@Column(name ="商品描述")
	private String description;


	private String detailDesc;

	@Column(name ="产品详情网页内容")
	private String detailHtml;

	@Column(name ="移动端网页详情")
	private String detailMobileHtml;


	private String detailTitle;


	private Long feightTemplateId;

	@Column(name ="赠送的成长值")
	private int giftGrowth;

	@Column(name ="赠送的积分")
	private int giftPoint;


	private String keyWords;

	@Column(name ="库存预警值")
	private int lowStock;


	private String name;

	@Column(name ="新品状态")
	private int newStatus;


	private String note;

	@Column(name ="市场价")
	private Number originalPrice;


	private String pic;

	@Column(name ="是否为预告商品")
	private int previewStatus;


	private Number price;


	private Long productAttributeCategoryId;


	private Long productCategoryId;

	@Column(name ="商品分类名称")
	private String productCategoryName;

	@Column(name ="货号")
	private String productSn;

	@Column(name ="促销结束时间")
	private String promotionEndTime;

	@Column(name ="活动限购数量")
	private int promotionPerLimit;

	@Column(name ="促销价格")
	private Number promotionPrice;

	@Column(name ="促销开始时间")
	private String promotionStartTime;

	@Column(name ="促销类型")
	private int promotionType;

	@Column(name ="上架状态")
	private int publishStatus;

	@Column(name ="推荐状态")
	private int recommandStatus;

	@Column(name ="销量")
	private int sale;

	@Column(name ="以逗号分割的产品服务")
	private String serviceIds;

	@Column(name ="排序")
	private int sort;

	@Column(name ="库存")
	private int stock;
	
	final int a = 10;

	@Column(name ="副标题")
	private String subTitle;

	@Column(name ="单位")
	private String unit;

	@Column(name ="限制使用的积分数")
	private int usePointLimit;

	@Column(name ="审核状态")
	private int verifyStatus;

	@Column(name ="商品重量，默认为克")
	private Number weight;

	@ManyToOne
	@JoinColumn
	private 
	
}