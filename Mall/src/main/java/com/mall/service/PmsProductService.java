package com.mall.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.param.PmsProductParam;
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
	 * @return: true:商品不存在，保存商品，false：商品存在，不保存商品
	 */
	public boolean productIsNotExsited(String name) {
		// 方法1：
//		for (PmsProduct product : pmsProductRepository.findAll()) {
//			if (product.getName().equals(name)) {
//				return false;
//			}
//		} 
//		return true;

		// 方法2：
		if (pmsProductRepository.findByName(name).isEmpty()) {
			return true;
		}
		return false;
	}

	public void createProuduct(PmsProductParam param) {

		if (productIsNotExsited(param.getName())) {
			PmsProduct pmsProduct = new PmsProduct();
			BeanUtils.copyProperties(param, pmsProduct);
			pmsProductRepository.save(pmsProduct);
		}

	}
}