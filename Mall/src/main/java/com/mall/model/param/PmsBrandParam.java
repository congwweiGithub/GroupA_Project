package com.mall.model.param;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PmsBrandParam{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String bigPic;
	// 专区大图

	private String brandStory;
	// 品牌故事

	private Integer factoryStatus;
	// 是否为品牌制造商：0->不是；1->是

	private String firstLetter;
	// 首字母

	private String logo;
	// 品牌logo

	private String name;

	private Integer productCommentCount;
	// 产品评论数量

	private Integer productCount;
	// 产品数量

	private Integer showStatus;

	private Integer sort;

}
