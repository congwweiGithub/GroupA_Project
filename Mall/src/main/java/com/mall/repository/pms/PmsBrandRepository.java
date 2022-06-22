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
	Page<PmsBrand> findByNameLike(Pageable pageable, String keyWord);

	// TODO 方法3：
//	Page<PmsBrand> findTop5ByNameLike(Pageable pageable, String keyWord);//只返回5条满足条件的结果

//	Page<PmsBrand> findTop10ByName(String keyword, Pageable pageable);//只返回10条满足条件的结果，及时pageSize是5，仍会在页面返回全部结果（>5）

//	Page<PmsBrand> findTop15ByName(String keyword, Pageable pageable);

}
