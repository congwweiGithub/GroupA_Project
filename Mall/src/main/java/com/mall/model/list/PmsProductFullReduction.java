package com.mall.model.list;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Entity
//@Table(name = "product_full_reduction")
@Data
public class PmsProductFullReduction {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Number fullPrice;
	
	private Long productId;
	
	private Number reducePrice;

}
