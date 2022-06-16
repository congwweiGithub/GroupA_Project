package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsBrand;
import com.mall.repository.pms.PmsBrandRepository;

@Service
public class PmsBrandService {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	public List<PmsBrand> findAllBrands() {
		return pmsBrandRepository.findAll();
	}

	public List<PmsBrand> findRequiredBrands(Integer pageNum, Integer pageSize) {

		return pmsBrandRepository.findRequiredBrands((pageNum - 1) * pageSize, pageSize);
	}
}
