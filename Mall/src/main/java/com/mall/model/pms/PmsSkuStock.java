package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
<<<<<<< Upstream, based on main

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

	// 锁定库存
	private Integer lockStock;

	// 预警库存
	private Integer lowStock;

	// 展示图片
	private String pic;

	private Double price;

	private Long productId;

	// 单品促销价格
	private Double promotionPrice;

	// 销量
	private Integer sale;

	// sku编码
	private Integer skuCode;

	// 商品销售属性，json格式
	private Integer spData;

	// 库存
	private Integer stock;
=======
import com.mall.model.pms.PmsProduct;

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
	private int lockStock;

	// @Column(name ="预警库存")
	private int lowStock;

	// @Column(name ="展示图片")
	private String pic;

	private double price;

	private Long productId;

	// @Column(name ="单品促销价格")
	private double promotionPrice;

	// @Column(name ="销量")
	private int integer;

	// @Column(name ="sku编码")
	private int skuCode;

	// @Column(name ="商品销售属性，json格式")
	private int spData;

	// @Column(name ="库存")
	private int stock;
>>>>>>> 5aabae6 统一项目包目录

}