package com.mall.repository.pms;

<<<<<<< HEAD
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

	
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git
}
