package com.mall.model.response;

import java.util.List;

import com.mall.model.pms.PmsBrand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResultPmsBrand {

	private List<PmsBrand> list;
	private Integer pageNum;
	private Integer pageSize;
	private Long total;
	private Integer totalPage;
	
	

}
