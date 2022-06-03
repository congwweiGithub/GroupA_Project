package com.mall.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
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
public class PmsProduct implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name ="画册图片")
	 private String albumPics;
	 
	 @Column(name ="图标")
	 private String icon;
	 
	 @Column(name ="品牌编号")
	 private Long brandId;
	 
	 @Column(name ="品牌名称")
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

	 @Column(name ="市场价")
	 private double originalPrice;

	 @Column(name ="")
	 private String pic;

	 @Column(name ="是否为预告商品")
	 private int previewStatus;

	 @Column(name ="")
	 private Number price;

	 @Column(name ="")
	 private Long productAttributeCategoryId;

	 @Column(name ="")
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
		
	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "pmsProduct",orphanRemoval = true)
	 private List<ProductLadderList> productLadderList = new ArrayList<>();
	
}


