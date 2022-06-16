package com.mall.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsBrand;
import com.mall.repository.pms.PmsBrandRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PmsBrandService {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<PmsBrand> findRequiredBrands(Integer pageNum, Integer pageSize) {
		if(pmsBrandRepository.count() <= pageSize) {
			return pmsBrandRepository.findAll();
		} else {
			return pmsBrandRepository.findRequiredBrands(pageNum, pageSize);
	} 
	        }

//	public List<List<PmsBrand>> findRequiredBrands(Integer pageNum, Integer pageSize) {
//
//		long totalBrands = pmsBrandRepository.count();
//		log.info("共有{}个品牌", totalBrands);
//
//		long totalPages = (totalBrands + (pageSize - 1)) / pageSize;
//		log.info("共{}页", totalPages);
//
//		List<List<PmsBrand>> brandPerPage = new ArrayList<List<PmsBrand>>();
//		for (long i = 0; i < totalPages; i++) {
//			List<PmsBrand> subList = new ArrayList<PmsBrand>();
//			for (long j = 0; j < totalBrands; j++) {
//				long index = ((j + 1) + (pageSize - 1)) / pageSize;
//				if (index == (i + 1)) {
//					List<PmsBrand> brandId = new ArrayList<PmsBrand>();
//					subList.add(brandId.get((int) j));// pmsBrandRepository.findById(j)
//				}
//				if ((j + 1) == ((j + 1) * pageSize)) {
//					break;
//				}
//			}
//			total.add(subList);
//		}
//		return total;
//	}
	
//	public List<PmsBrand> findBrandsByMath(Integer pageNum, Integer pageSize){
//		
//		if(pmsBrandRepository.count() <= pageSize) {
//			return pmsBrandRepository.findAll();
//		} else {
//		long max;
//		long min;
//		max = pageNum * pageSize - 1;//	期望页码最大id值
//		min = pageNum * pageSize - pageSize;//期望页码最小id值
//		
//		for (long i = min; i < max; i++) {
//			List<PmsBrand> requiredIds = 
//		}
//	
//		pmsBrandRepository.findAllById(null)
//		return pmsBrandRepository.findById();
//		
//	}

//	public List<PmsBrand> findByKeyword(String keyword){
//		return pmsBrandRepository.findByKeyword(keyword);
//		
//	}
	
	//DATA52行
//	TRUNCATE TABLE pms_brand;
//	INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
//	VALUES ('10','string','string','0','a','logoimg','华为','0','0','0','0');
//	INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
//	VALUES ('11','string','string','0','a','logoimg','OPPO','0','0','0','0');
//	INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
//	VALUES ('12','string','string','0','a','logoimg','小米','0','0','0','0');
//
//	TRUNCATE TABLE pms_brand;
//	INSERT INTO pms_brand (id,big_pic,brand_story,factory_status,first_letter,logo,name,product_comment_count,product_count,show_status,sort)
//	VALUES ('21','string','string','0','a','logoimg','Apple','0','0','0','0');

}
