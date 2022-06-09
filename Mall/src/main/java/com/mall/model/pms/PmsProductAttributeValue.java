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
public class PmsProductAttributeValue {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	private Long productAttributeId;

	private Long productId;

	// 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
=======
import com.mall.model.pms.PmsProduct;

import lombok.Data;

@Entity
@Data
public class PmsProductAttributeValue {
	
	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long productAttributeId;
	
	private Long productId;

	//@Column(name ="手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
>>>>>>> 5aabae6 统一项目包目录
	private String value;

}