package com.mall.model.list;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.mall.model.PmsProduct;

import lombok.Data;

@Entity
@Data
public class PmsSkuStock {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	// @Column(name ="锁定库存")
	private Integer lockStock;

	// @Column(name ="预警库存")
	private Integer lowStock;

	// @Column(name ="展示图片")
	private String pic;

	private double price;

	private Long productId;

	// @Column(name ="单品促销价格")
	private double promotionPrice;

	// @Column(name ="销量")
	private int sale;

	// @Column(name ="sku编码")
	private Integer skuCode;

	// @Column(name ="商品销售属性，json格式")
	private Integer spData;

	// @Column(name ="库存")
	private Integer stock;

}