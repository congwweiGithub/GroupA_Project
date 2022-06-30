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

	// 方法1：
	@Query(value = "SELECT * FROM pms_brand ORDER BY pms_brand.id LIMIT ?2 OFFSET ?1 ;", nativeQuery = true)
	List<PmsBrand> findRequiredBrands(Integer startFrom, Integer pageSize);

	// 方法2：
	Page<PmsBrand> findByNameLike(Pageable pageable, String keyword);

}
