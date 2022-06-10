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

	//JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_id")
	private PmsProduct pmsProduct;

	@Id
	@GeneratedValue
	private Long id;

	private Long prefrenceAreaId;

	private Long productId;

}