package com.mall.repository.pms;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsBrand;

@Repository
public interface PmsBrandRepository extends JpaRepository<PmsBrand, Long> {
	Page<PmsBrand> findAll(Pageable pageable);
	
	Page<PmsBrand> findByNameLike(String keyword, Pageable pageable);
	
	List<PmsBrand> findByName(String keyword);
	
	@Query(value = "SELECT * FROM pms_brand ORDER BY pms_brand.id LIMIT ?2 OFFSET ?1 ;", nativeQuery = true)
	List<PmsBrand> findRequiredBrands(Integer startFrom, Integer pageSize);
	
	//List<PmsBrand> findByNameLike(String keyword);
	
	@Query(value = "SELECT * FROM pms_brand WHERE pms_brand.name LIKE '%?1%' ORDER BY pms_brand.id;", nativeQuery = true)
	List<PmsBrand> findRequiredBrandsUsingKeyword(String keyword);
	
}