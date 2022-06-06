package com.GroupAMall.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GroupAMall.models.PmsProduct;
import com.GroupAMall.repositories.PmsProductRepository;

@Service
public class PmsProductService {
	
	@Autowired
	private PmsProductRepository pmsProductRepository;
	
	@Transactional
	public PmsProduct create(/*Product的参数类型 参数*/) {
		return pmsProductRepository.save(new PmsProduct(/*参数*/));
	}
	

}
