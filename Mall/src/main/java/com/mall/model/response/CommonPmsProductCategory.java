package com.mall.model.response;

import java.util.List;
<<<<<<< HEAD

import com.mall.model.pms.PmsProductCategory;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPmsProductCategory {
	
	private List<PmsProductCategory> children;
=======
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPmsProductCategory {
	
	private List<PmsProductCategoryWithChildrenItem> children;
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git
	
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
