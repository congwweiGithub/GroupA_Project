package com.mall.repository.pms;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;

@Repository
public interface PmsProductCategoryWithChildrenRepository extends JpaRepository<PmsProductCategoryWithChildrenItem,Long> { 
	
	PmsProductCategoryWithChildrenItem findByName(String name);

	PmsProductCategoryWithChildrenItem findAllById(long l);
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mall.model.pms.PmsProductCategoryWithChildrenItem;

@Repository
public interface PmsProductCategoryWithChildrenRepository extends JpaRepository<PmsProductCategoryWithChildrenItem,Long> { 
	
	PmsProductCategoryWithChildrenItem findByProductCategoryId(Long id);
>>>>>>> branch 'GroupA_CongWei' of https://github.com/congwweiGithub/GroupA_Project.git
	
}