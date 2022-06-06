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
public class PmsMemberPrice {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	private Long memberLevelId;

	private String memberLevelName;

	// 会员价格
	private double memberPrice;

	private Long productId;

}
