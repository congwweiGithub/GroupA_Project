package com.mall.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.mall.model.list.PmsProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "pms_product_category_with_children_item")
public class PmsProductCategoryWithChildrenltem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
   
	private String icon;	      
	
	private String keywords;
	
	private Integer leve;
	
	private String name;
	
	private Integer navStatus;
	
	private Long  parentId;
	
	private Integer productCount;
	
	private Integer productUnit;
	
	private Integer showStatus;	
	
	private Integer sort;
	
	@OneToMany(mappedBy = "pmsProductCategoryWithChildrenltem")
	private List<PmsProductCategory> pmsProductCategory;
	      	    	          	        
}

