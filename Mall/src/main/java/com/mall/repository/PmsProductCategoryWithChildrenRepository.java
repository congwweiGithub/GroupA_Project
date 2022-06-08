package com.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.PmsProductCategoryWithChildrenItem;

@Repository
public interface PmsProductCategoryWithChildrenRepository extends JpaRepository<PmsProductCategoryWithChildrenItem,Long> { 
	
	PmsProductCategoryWithChildrenItem findByProductCategoryId(Long id);
	
}