package com.mall.repository.pms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsProduct;
import com.mall.model.pms.PmsProductLadder;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct, Long> {
	PmsProduct findByName(String name);

	void save(List<PmsProductLadder> pmsProductLadder);

}
