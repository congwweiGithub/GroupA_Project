package com.mall.repository.pms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsProductCategoryWithChildrenItem;

@Repository
public interface PmsProductCategoryWithChildrenRepository
		extends JpaRepository<PmsProductCategoryWithChildrenItem, Long> {

	List<PmsProductCategoryWithChildrenItem> findByName(String name);

}