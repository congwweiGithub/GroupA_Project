package com.mall.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonPage <T> {
	
	private List<T> list;
	private Integer pageNum; 
	private Integer pageSize;
	private Long total;
	private Integer totalPage;
	
}
