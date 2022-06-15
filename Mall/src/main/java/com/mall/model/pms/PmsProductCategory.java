package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PmsProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	private String icon;

	private String keywords;

	private Integer level;

	private String name;

	private Integer navStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	@JsonBackReference
	private PmsProductCategoryWithChildrenItem parent;

	private Integer productCount;

	private String productUnit;

	private Integer showStatus;

	private Integer sort;

	@Override
	public String toString() {
		return "PmsProductCategory [id=" + id + ", description=" + description + ", icon=" + icon + ", keywords="
				+ keywords + ", level=" + level + ", name=" + name + ", navStatus=" + navStatus
				+ ", pmsProductCategoryWithChildrenItem=" + parent.getId() + ", productCount=" + productCount
				+ ", productUnit=" + productUnit + ", showStatus=" + showStatus + ", sort=" + sort + "]";
	}

//	public Long getParentId() {
//
//		return parent.getId();
//
//	}

}
