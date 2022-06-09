package com.mall.model.cms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mall.model.pms.PmsProduct;

import lombok.Data;

@Entity
@Data
public class CmsPrefrenceAreaProductRelation {

<<<<<<< Upstream, based on main
	// JPA多对一
=======
	//JPA多对一
>>>>>>> 5aabae6 统一项目包目录
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	private Long prefrenceAreaId;

	private Long productId;

}