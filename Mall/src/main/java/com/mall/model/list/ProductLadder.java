package com.mall.model.list;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//@Table(name = "product_ladder")
@Data
public class ProductLadder {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name ="满足的商品数量")
	private int count;
	
	@Column(name ="折扣")
	private Number discount;

	@Column(name ="折后价格")
	private Number price;

	private Long productId;

}
