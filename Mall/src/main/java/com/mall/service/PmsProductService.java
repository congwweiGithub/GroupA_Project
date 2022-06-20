package com.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsProduct;
import com.mall.repository.pms.PmsProductRepository;

//TODO
@Service
public class PmsProductService {

	@Autowired
	PmsProductRepository pmsProductRepository;

	/**
	 * 
	 * @param param
	 * @param name
	 * @return: 0:商品不存在，保存商品，1：商品存在，不保存商品
	 */
	public int productExsited(String name) {
		int count = 0;
		for (PmsProduct product : pmsProductRepository.findAll()) {
			if (product.getName().equals(name)) {
				count = 1;
				break;
			} else {
				count = 0;
			}
		}
		return count;

	}

//		if() {
//			
//		}
}
