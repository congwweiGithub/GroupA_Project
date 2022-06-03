package com.mall.model.response;

import java.util.List;

import com.mall.model.PmsProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonPagePmsProduct {
	
	private List<PmsProduct> list;
	private int pageNum;
	private int pageSize;
	private Long total;
	private int totalPage;
	
}
