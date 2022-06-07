package com.mall.model.list;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.mall.model.PmsProductCategoryWithChildrenltem;
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
public class PmsProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pms_product_category_with_children_item_id")
	private PmsProductCategoryWithChildrenltem pmsProductCategoryWithChildrenltem;
	
}
