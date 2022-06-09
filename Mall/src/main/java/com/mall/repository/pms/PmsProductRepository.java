package com.mall.repository.pms;

<<<<<<< Upstream, based on main
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mall.model.pms.PmsProduct;
import com.mall.model.pms.PmsProductLadder;

@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct, Long> {
	PmsProduct findByName(String name);

	void save(List<PmsProductLadder> pmsProductLadder);

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.model.pms.PmsProduct;


@Repository
public interface PmsProductRepository extends JpaRepository<PmsProduct,Long> { 
	 PmsProduct findByName(String name);

	
>>>>>>> 5aabae6 统一项目包目录
}
