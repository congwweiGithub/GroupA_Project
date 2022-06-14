package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private PmsProduct pmsProduct;

}
