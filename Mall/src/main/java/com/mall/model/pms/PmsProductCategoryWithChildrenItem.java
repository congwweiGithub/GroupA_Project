package com.mall.model.pms;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	@OneToMany
	@JoinColumn(name = "pms_product_category_with_children_item_id")
//	@ToString.Exclude
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