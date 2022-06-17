package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsBrand;
import com.mall.model.response.CommonResultPmsBrand;
import com.mall.repository.pms.PmsBrandRepository;

@Service
public class PmsBrandService {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	public List<PmsBrand> findAllBrands() {
		return pmsBrandRepository.findAll();
	}

	public CommonResultPmsBrand findRequiredBrands(Integer pageNum, Integer pageSize) {

<<<<<<< Upstream, based on origin/GroupA_CongWei
		long pmsBrandCount = pmsBrandRepository.count();
		Long totalCount = pmsBrandCount;// 总个数
		Integer total = totalCount.intValue();
		Integer result = total % pageSize;
		// 总页数
		Integer totalPage = (Integer) (result > 0 ? // 如果取模大于0说明总个数和每页显示个数整除后需要加一页
				total / pageSize + 1 : total / pageSize);

		CommonResultPmsBrand commonResultPmsBrand = CommonResultPmsBrand.builder()//
				.list(pmsBrandRepository.findRequiredBrands((pageNum - 1) * pageSize, pageSize))//
				.pageNum(pageNum)//
				.pageSize(pageSize)//
				.total((long) total)//
				.totalPage(totalPage)//
				.build();

		return commonResultPmsBrand;

=======
		Long total = pmsBrandRepository.count();
		Integer totalPage = (int) (total / pageSize + 1);

		CommonResultPmsBrand commonResultPmsBrand = CommonResultPmsBrand.builder()//
				.list(pmsBrandRepository.findRequiredBrands((pageNum - 1) * pageSize, pageSize))//
				.pageNum(pageNum)//
				.pageSize(pageSize)//
				.total(total)//
				.totalPage(totalPage)//
				.build();

		return commonResultPmsBrand;
>>>>>>> b08c1d3 返回总页数和总条数
	}
}
