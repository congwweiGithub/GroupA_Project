package com.mall.model.param;

import java.util.List;

import com.mall.model.pms.PmsProductCategoryWithChildrenItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPmsProductCategory {
	
	private List<PmsProductCategoryWithChildrenItem> children;
	
	private Long id;
	
	private String description;
	   
	private String icon;	      
	
	private String keywords;
	
	private Integer leve;
	
	private String name;
	
	private Integer navStatus;
			
	private Integer productCount;
	
	private Integer productUnit;
	
	private Integer showStatus;	
	
	private Integer sort;
	
	private Long  parentId;
	
	
			
}
