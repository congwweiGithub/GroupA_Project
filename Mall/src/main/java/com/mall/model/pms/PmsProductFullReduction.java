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
public class PmsProductFullReduction {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	private Double fullPrice;

	private Long productId;

	private Double reducePrice;
=======
import com.mall.model.pms.PmsProduct;

import lombok.Data;

@Entity
@Data
public class PmsProductFullReduction {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	private double fullPrice;

	private Long productId;

	private double reducePrice;
>>>>>>> 5aabae6 统一项目包目录

}