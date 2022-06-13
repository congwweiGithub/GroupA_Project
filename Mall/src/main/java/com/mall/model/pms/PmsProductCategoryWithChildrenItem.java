package com.mall.model.pms;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmsProductCategoryWithChildrenItem {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pmsProductCategoryWithChildrenItem")
	@JsonManagedReference
	private List<PmsProductCategory> children;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	private String icon;

	private String keywords;

	private Integer level;

	private String name;

	private Integer navStatus;

	private Long parentId;

	private Integer productCount;

	private Integer productUnit;

	private Integer showStatus;

	private Integer sort;

}
