package com.mall.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mall.model.param.PmsProductParam;
import com.mall.model.pms.PmsProduct;
import com.mall.model.response.CommonPage;
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

	public List<PmsProduct> findAllProducts() {
		return pmsProductRepository.findAll();
	}

	public CommonPage<PmsProduct> findRequiredProducts(Integer pageNum, Integer pageSize, String keyword) {

		CommonPage<PmsProduct> commonPage;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<PmsProduct> productsList;
		Page<PmsProduct> products;

		if (keyword == null) {
			products = pmsProductRepository.findAll(pageable);
		} else {
			products = pmsProductRepository.findByNameLike(pageable, ("%" + keyword + "%"));
		}
		productsList = products.getContent();

		commonPage = new CommonPage<PmsProduct>(productsList, pageNum, pageSize, products.getTotalElements(),
				products.getTotalPages());
		return commonPage;
	}
}