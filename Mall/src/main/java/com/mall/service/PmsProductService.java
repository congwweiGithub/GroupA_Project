package com.mall.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mall.repository.pms.PmsProductRepository;
//TODO
@Service
public class PmsProductService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductService.class);
	
	@Autowired
	PmsProductRepository product;
	

}
	

