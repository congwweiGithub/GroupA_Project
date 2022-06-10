<<<<<<< HEAD
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

=======
package com.mall.model.response ;

import java.util.List;
import com.mall.model.pms.PmsProduct;
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
	private Integer pageNum;
	private Integer pageSize;
	private Long total;
	private Integer totalPage;
	
}
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git
