package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mall.model.pms.PmsProduct;

import lombok.Data;

@Entity
@Table(name = "product_ladder")
@Data
public class PmsProductLadder  {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Column(name ="满足的商品数量")
	private int count;
	
//	@Column(name ="折扣")
	private double discount;

//	@Column(name ="折后价格")
	private double price;
	
	private Long productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pms_product_id")
    private PmsProduct pmsProduct;

}

