package com.mall.model.pms;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name ="pms_product_category")
public class PmsProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< HEAD
	private Long id;
=======
	private Long childrenId;
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git
	
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
			
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private PmsProductCategoryWithChildrenItem item;
			
}

