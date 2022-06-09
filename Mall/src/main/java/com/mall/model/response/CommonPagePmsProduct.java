package com.mall.model.response;

import java.util.List;

import com.mall.model.pms.PmsProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonPagePmsProduct {

	private List<PmsProduct> list;
	private Integer pageNum;
	private Integer pageSize;
	private Long total;
	private Integer totalPage;

}

