package com.mall.model.pms;

import javax.persistence.Entity;
<<<<<<< HEAD
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
=======
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_ladder")
@Data
public class PmsProductLadder  {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    //满足的商品数量
	private int count;
	
    //折扣
	private double discount;

    //折后价格
	private double price;
	
	private Long productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pms_product_id")
    private PmsProduct pmsProduct;
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git

}

