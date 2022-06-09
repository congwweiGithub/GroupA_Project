package com.mall.model.oms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class OmsOrderItem {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oms_order_id")
	private OmsOrder omsOrder;

	@Id
	@GeneratedValue
	private Long id;

	private double couponAmount;
	// 优惠券优惠分解金额

	private int giftGrowth;

	private int giftIntegration;

	private double integrationAmount;
	// 积分优惠分解金额

	private Long orderId;
	// 订单id

	private String orderSn;
	// 订单编号

	private String productAttr;
	// 商品销售属性:[{'key':'颜色','value':'颜色'},{'key':'容量','value':'4G'}]

	private String productBrand;

	private Long productCategoryId;
	// 商品分类id

	private Long productId;
	//

	private String productName;

	private String productPic;

	private double productPrice;
	// 销售价格

	private int productQuantity;
	// 购买数量

	private String productSkuCode;
	// 商品sku条码

	private Long productSkuId;
	// 商品sku编号

	private String productSn;

	private double promotionAmount;
	// 商品促销分解金额

	private String promotionName;
	// 商品促销名称

	private double realAmount;
	// 该商品经过优惠后的分解金额

}
