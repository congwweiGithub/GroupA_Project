package com.mall.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mall.model.list.ProductLadderList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmsProduct {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name ="画册图片")
	 private String albumPics;
	 
	 @Column(name ="图标")
	 private String icon;
	 
	 @Column(name ="品牌编号")
	 private Long brandId;
	 
	 @Column(name ="商品品牌")
	 private String brandName;
	 
	 @Column(name ="删除状态")
	 private int deleteStatus;

	 @Column(name ="商品描述")
	 private String description;

	 @Column(name ="详情")
	 private String detailDesc;

	 @Column(name ="产品详情网页内容")
	 private String detailHtml;

	 @Column(name ="移动端网页详情")
	 private String detailMobileHtml;

	 @Column(name ="")
	 private String detailTitle;

	 @Column(name ="")
	 private Long feightTemplateId;

	 @Column(name ="赠送的成长值")
	 private int giftGrowth;

	 @Column(name ="赠送的积分")
	 private int giftPoint;

	 @Column(name ="关键字")
	 private String keyWords;

	 @Column(name ="库存预警值")
	 private int lowStock;

	 @Column(name ="商品名称")
	 private String name;

	 @Column(name ="新旧状态")
	 private int newStatus;

	 @Column(name ="")
	 private String note;

	 @Column(name ="商品原价")
	 private double originalPrice;

	 @Column(name ="")
	 private String pic;

	 @Column(name ="是否为预告商品")
	 private int previewStatus;

	 @Column(name ="商品价格")
	 private double price;

	 @Column(name ="")
	 private Long productAttributeCategoryId;

	 @Column(name ="")
	 private Long productCategoryId;

	 @Column(name ="商品分类")
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
	 
	 @Column(name = "库存")
	 private int stock;

	 @Column(name = "副标题")
	 private String subTitle;

	 @Column(name = "单位")
	 private String unit;

	 @Column(name = "限制使用的积分数")
	 private int usePointLimit;
	 @Column(name = "审核状态")
	 private int verifyStatus;

	 @Column(name = "商品重量，默认为克")
	 private Number weight;

	
	 @OneToMany(mappedBy = "pmsProduct")
	 private List<ProductLadderList> productLadderList;
	
}


