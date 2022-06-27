package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsBrand;
import com.mall.model.response.CommonPage;
import com.mall.repository.pms.PmsBrandRepository;

@Service
public class PmsBrandService {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	public List<PmsBrand> findAllBrands() {
		return pmsBrandRepository.findAll();
	}

//	public CommonResultPmsBrand findRequiredBrands(Integer pageNum, Integer pageSize) {
//
//		long pmsBrandCount = pmsBrandRepository.count();
//		Long totalCount = pmsBrandCount;// 总个数
//		Integer total = totalCount.intValue();
//		Integer result = total % pageSize;
//		// 总页数
//		Integer totalPage = (Integer) (result > 0 ? // 如果取模大于0说明总个数和每页显示个数整除后需要加一页
//				total / pageSize + 1 : total / pageSize);
//
//		CommonResultPmsBrand commonResultPmsBrand = CommonResultPmsBrand.builder()//
//				.list(pmsBrandRepository.findRequiredBrands((pageNum - 1) * pageSize, pageSize))//
//				.pageNum(pageNum)//
//				.pageSize(pageSize)//
//				.total((long) total)//
//				.totalPage(totalPage)//
//				.build();
//
//		return commonResultPmsBrand;
//
//	}

	public CommonPage<PmsBrand> findRequiredBrands(Integer pageNum, Integer pageSize, String keyword) {

		CommonPage<PmsBrand> commonPage;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<PmsBrand> brandsList;
		Page<PmsBrand> brands;

		if (keyword == null) {
			brands = pmsBrandRepository.findAll(pageable);
		} else {
			brands = pmsBrandRepository.findByNameLike(pageable, ("%" + keyword + "%"));
		}
		brandsList = brands.getContent();

		commonPage = new CommonPage<PmsBrand>(brandsList, pageNum, pageSize, brands.getTotalElements(),
				brands.getTotalPages());
		return commonPage;
	}

}
