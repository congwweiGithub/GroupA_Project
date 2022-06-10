package com.mall.repository.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsProductCategoryWithChildrenItem;

@Repository
public interface PmsProductCategoryWithChildrenRepository
		extends JpaRepository<PmsProductCategoryWithChildrenItem, Long> {

	PmsProductCategoryWithChildrenItem findAllById(Long l);

}