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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

	private String productUnit;

	private Integer showStatus;

	private Integer sort;

	@Override
	public String toString() {
		return "PmsProductCategoryWithChildrenItem [children=" + children + ", id=" + id + ", description="
				+ description + ", icon=" + icon + ", keywords=" + keywords + ", level=" + level + ", name=" + name
				+ ", navStatus=" + navStatus + ", parentId=" + parentId + ", productCount=" + productCount
				+ ", productUnit=" + productUnit + ", showStatus=" + showStatus + ", sort=" + sort + "]";
	}

}
