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
	private String value;

}
