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
	}
}
