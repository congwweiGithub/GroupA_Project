package com.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.model.list.PmsProductCategory;

@Repository
public interface PmsProductCategoryRepository extends JpaRepository<PmsProductCategory,Long> { 
	
//	PmsProductCategory findById(Long id);
	
}