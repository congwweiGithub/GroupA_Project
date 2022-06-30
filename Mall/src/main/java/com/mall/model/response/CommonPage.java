package com.mall.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPage<T> {

	private List<T> list;
	private Integer pageNum;
	private Integer pageSize;
	private Long total;
	private Integer totalPage;

}
