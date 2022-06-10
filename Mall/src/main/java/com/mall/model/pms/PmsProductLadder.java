package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PmsProductLadder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	满足的商品数量
	private Integer count;

//	折扣
	private Double discount;

//	折后价格
	private Double price;

	private Long productId;

	@ManyToOne
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

}
