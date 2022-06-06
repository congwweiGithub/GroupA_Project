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
public class PmsProductLadder {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	// 满足的商品数量
	private int count;

	// 折扣
	private double discount;

	// 折后价格
	private double price;

	private Long productId;

}
