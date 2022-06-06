package com.GroupAMall.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GroupAMall.models.PmsProduct;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct,Long>{
	
	PmsProduct findByProductId(Long id);
	


}
