package com.mall.model.response;

import java.util.List;

import com.mall.model.pms.PmsProductCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CommonPmsProductCategory {

	@ToString.Exclude
	private List<PmsProductCategory> children;

	private Long id;

	private String description;

	private String icon;

	private String keywords;

	private Integer leve;

	private String name;

	private Integer navStatus;

	private Long parentId;

	private Integer productCount;

	private Integer productUnit;

	private Integer showStatus;

	private Integer sort;

}
