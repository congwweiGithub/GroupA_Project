package com.mall.repository.pms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsProductCategory;

@Repository
public interface PmsProductCategoryRepository extends JpaRepository<PmsProductCategory, Long> {

	PmsProductCategory findAllById(Long id);

}
