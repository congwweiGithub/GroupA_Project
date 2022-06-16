package com.mall.repository.pms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsBrand;

@Repository
public interface PmsBrandRepository extends JpaRepository<PmsBrand, Long> {

	List<PmsBrand> findAll();

	@Query(value = "SELECT * FROM pms_brand ORDER BY pms_brand.id LIMIT ?2 ;", nativeQuery = true)
	List<PmsBrand> findRequiredBrands(Integer pageNum, Integer pageSize);

}
