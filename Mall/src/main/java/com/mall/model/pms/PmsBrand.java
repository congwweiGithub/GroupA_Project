package com.mall.model.pms;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmsBrand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Basic
	private String bigPic;
	// 专区大图

	@Basic
	private String brandStory;
	// 品牌故事

	@Basic
	private Integer factoryStatus;
	// 是否为品牌制造商：0->不是；1->是

	@Basic
	private String firstLetter;
	// 首字母

	@Basic
	private String logo;
	// 品牌logo

	@Basic
	private String name;

	@Basic
	private Integer productCommentCount;
	// 产品评论数量

	@Basic
	private Integer productCount;
	// 产品数量

	@Basic
	private Integer showStatus;

	@Basic
	private Integer sort;

}
