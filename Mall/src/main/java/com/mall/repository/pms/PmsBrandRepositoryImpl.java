//package com.mall.repository.pms;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.mall.model.pms.PmsBrand;
//
//@Repository
//public class PmsBrandRepositoryImpl {
//	
//	@Autowired
//	PmsBrandRepository pmsBrandRepository;
//
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public List<PmsBrand> findRequiredBrands(Integer pageNum, Integer pageSize) {
//		if(pmsBrandRepository.count() <= pageSize) {
//			return pmsBrandRepository.findAll();
//		} else {
//	}
//	        return entityManager.createQuery("SELECT * FROM pms_brand ORDER BY pms_brand.id", PmsBrand.class)//
//	        		.setMaxResults(pageSize)//
//	        		.getResultList();
//	        }
//	
//
//}
