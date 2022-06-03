package com.mall.model.list;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mall.model.PmsProduct;

import lombok.Data;

@Entity
@Table(name = "product_ladder")
@Data
public class ProductLadderList implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pms_product_id")
    private PmsProduct pmsProduct;

}
