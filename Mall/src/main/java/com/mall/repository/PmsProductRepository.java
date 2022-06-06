package com.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.PmsProduct;
import com.mall.model.param.PmsProductParam;


@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct,Long> { 
	 PmsProductParam findByName(String name);

	void save(PmsProductParam pmsProductParam);



	
}
