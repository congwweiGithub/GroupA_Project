package com.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.model.PmsProduct;


@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct,Long> { 
	 PmsProduct findByName(String name);

	
}
