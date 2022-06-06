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

	// 锁定库存
	private int lockStock;

	// 预警库存
	private int lowStock;

	// 展示图片
	private String pic;

	private double price;

	private Long productId;

	// 单品促销价格
	private double promotionPrice;

	// 销量
	private int integer;

	// sku编码
	private int skuCode;

	// 商品销售属性，json格式
	private int spData;

	// 库存
	private int stock;

}
