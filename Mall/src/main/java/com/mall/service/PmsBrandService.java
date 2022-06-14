package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.param.PmsBrandParam;
import com.mall.model.pms.PmsBrand;
import com.mall.repository.pms.PmsBrandRepository;

@Service
public class PmsBrandService {
	
	@Autowired
	PmsBrandRepository pmsBrandRepository;
	
	public List<PmsBrand> FindAllBrands(){
		return pmsBrandRepository.findAll();
	}
	
}
