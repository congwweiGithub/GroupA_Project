package com.mall.model.cms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mall.model.pms.PmsProduct;

import lombok.Data;

@Entity
@Data
public class CmsSubjectProductRelation {

	@Id
	@GeneratedValue
	private Long id;

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private PmsProduct pmsProduct;

	private Long subjectId;

}