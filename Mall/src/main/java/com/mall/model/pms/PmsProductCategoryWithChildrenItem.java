package com.mall.model.pms;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="pms_product_category_with_children_item")
public class PmsProductCategoryWithChildrenItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productCategoryId;
	
	private String description;
   
	private String icon;	      
	
	private String keywords;
	
	private Integer level;
	
	private String name;
	
	private Integer navStatus;
			
	private Integer productCount;
	
	private Integer productUnit;
	
	private Integer showStatus;	
	
	private Integer sort;
	
	private Long  parentId;
			
	@OneToMany(mappedBy = "item")
	private List<PmsProductCategory> children;
}
