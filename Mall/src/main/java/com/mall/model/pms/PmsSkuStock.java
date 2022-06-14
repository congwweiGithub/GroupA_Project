package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class PmsSkuStock {

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

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private PmsProduct pmsProduct;

	// 单品促销价格
	private Double promotionPrice;

	// 销量
	private Integer integer;

	// sku编码
	private Integer skuCode;

	// 商品销售属性，json格式
	private Integer spData;

	// 库存
	private Integer stock;

}