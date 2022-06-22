package com.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsBrand;
import com.mall.model.response.CommonResultPmsBrand;
import com.mall.repository.pms.PmsBrandRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PmsBrandService {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	public CommonResultPmsBrand findRequiredBrands(Integer pageNum, Integer pageSize, String keyword) {
		
		Pageable getPageInfo = PageRequest.of(pageNum, pageSize);
		Page<PmsBrand> allBrands = pmsBrandRepository.findByNameLike(keyword, getPageInfo);
		List<PmsBrand> allBrandsList = allBrands.getContent();
		
		log.info("{},{},{}", keyword,pageNum,pageSize);
		


		CommonResultPmsBrand commonResultPmsBrand = CommonResultPmsBrand.builder()//
				.list(allBrandsList)//
				.pageNum(pageNum)//
				.pageSize(pageSize)//
				.total(allBrands.getTotalElements())//
				.totalPage(allBrands.getTotalPages())//
				.build();

		return commonResultPmsBrand;
	}
	

}
