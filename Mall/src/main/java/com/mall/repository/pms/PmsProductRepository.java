package com.mall.repository.pms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsProduct;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct, Long> {

	@Query(value = "SELECT * FROM pms_product WHERE name = :name", nativeQuery = true)
	List<PmsProduct> productExsits(String name);
}
