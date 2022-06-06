package com.GroupAMall.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "member_price")
@Data
public class PmsMenberPrice {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long memberLevelId;
	
	private String memberLevelName;
	
	@Column(name ="会员价格")
	private Number memberPrice;
	
	private Long productId;
	

}
