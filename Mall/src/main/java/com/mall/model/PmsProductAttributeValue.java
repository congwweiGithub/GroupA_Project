package com.mall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Entity
//@Table(name = "product_attribute_value")
@Data
public class PmsProductAttributeValue {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long productAttributeId;
	
	private Long productId;

	@Column(name ="手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开")
	private String value;

}
