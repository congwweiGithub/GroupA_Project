package com.mall.model.param;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PmsBrandParam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//专区大图
	private String bigPic;
	
	//品牌故事
	private String brandStory;
	
	//是否为品牌制造商：0->不是；1->是
	private Integer factoryStatus;
	
	//首字母
	private String firstLetter;
	
	//品牌logo
	private String logo;
	
	private String name;
	
	//产品评论数量
	private Integer productCommentCount;
	
	//产品数量
	private Integer productCount;

	private Integer showStatus;
	
	private Integer sort;

}
=======


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PmsBrandParam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//专区大图
	private String bigPic;
	
	//品牌故事
	private String brandStory;
	
	//是否为品牌制造商：0->不是；1->是
	private Integer factoryStatus;
	
	//首字母
	private String firstLetter;
	
	//品牌logo
	private String logo;
	
	private String name;
	
	//产品评论数量
	private Integer productCommentCount;
	
	//产品数量
	private Integer productCount;

	private Integer showStatus;
	
	private Integer sort;

}
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git
