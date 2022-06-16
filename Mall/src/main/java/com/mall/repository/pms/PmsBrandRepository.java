package com.mall.repository.pms;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsBrand;

@Repository
public interface PmsBrandRepository extends JpaRepository<PmsBrand, Long> {
	List<PmsBrand> findAll();
	
	@Query(value = "SELECT * FROM pms_brand ORDER BY pms_brand.id LIMIT \\id-- #pageSize\\id", nativeQuery = true)
	List<PmsBrand> findRequiredBrands(Integer pageNum, Integer pageSize);

}