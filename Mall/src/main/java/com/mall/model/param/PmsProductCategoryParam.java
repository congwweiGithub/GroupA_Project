package com.mall.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PmsProductCategoryParam {

	private Long id;

	private String description;

	private String icon;

	private String keywords;

	private String name;

	private Integer navStatus;

	private Long parentId;

//	private List<ProductAttribute> productAttributeIdList;

	private String productUnit;

	private Integer showStatus;

	private Integer sort;
}
