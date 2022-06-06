package com.GroupAMall.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sku_stock")
@Data
public class SkuStock {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name ="锁定库存")
	private int lockStock;


	@Column(name ="预警库存")
	private int lowStock;

	@Column(name ="展示图片")
	private String pic;

	private Number price;
	
	private Long productId;

	@Column(name ="单品促销价格")
	private Number promotionPrice;

	@Column(name ="销量")
	private int integer;

	@Column(name ="sku编码")
	private int skuCode;

	@Column(name ="商品销售属性，json格式")
	private int spData;

	@Column(name ="库存")
	private int stock;
	

}
