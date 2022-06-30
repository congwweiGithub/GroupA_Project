package com.mall.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.param.PmsProductParam;
import com.mall.model.pms.PmsProduct;
import com.mall.repository.pms.PmsProductRepository;

@Service
public class PmsProductService {

	@Autowired
	PmsProductRepository pmsProductRepository;

	// @return: true:商品存在，false：商品不存在

	public boolean productIsExsiting(String name) {// ****责任单一原则

		PmsProduct pmsProduct = pmsProductRepository.findByName(name);

		if (pmsProduct == null) {
			return false;
		}
		return true;
	}

	public void createProuduct(PmsProductParam param) {

		PmsProduct pmsProduct = new PmsProduct();
		BeanUtils.copyProperties(param, pmsProduct);
		pmsProductRepository.save(pmsProduct);

	}
}