package com.mall.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mall.model.pms.PmsBrand;
import com.mall.model.response.CommonResultPmsBrand;
import com.mall.repository.pms.PmsBrandRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PmsBrandService {

	@Autowired
	PmsBrandRepository pmsBrandRepository;

	public CommonResultPmsBrand findRequiredBrands(Integer pageNum, Integer pageSize, String keyword) {

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);// 控制页码变化
		List<PmsBrand> brandsList;
		Page<PmsBrand> brands;
		log.info("Service参数:keyword {}, pageNum {}, pageSize {}", keyword, pageNum, pageSize);

		if (keyword == null) {// 关键字不输入内容
			brands = pmsBrandRepository.findAll(pageable);
			brandsList = brands.getContent();
			log.info("无关键字");
			log.info("获得的品牌有：" + brands.getContent().toString());

		} else {// 通过关键字查询
			brands = pmsBrandRepository.findByNameLike(("%" + keyword + "%"), pageable);
			brandsList = brands.getContent();
			log.info("关键字 {}", keyword);
		}
		// 将判断结果build到commonresult
		CommonResultPmsBrand commonResultPmsBrand = CommonResultPmsBrand.builder()//
				.list(brandsList)//
				.pageNum(pageNum)//
				.pageSize(pageSize)//
				.total(brands.getTotalElements())//
				.totalPage(brands.getTotalPages())//
				.build();
		log.info("共{}个品牌，共{}页，每页{}个，当前页码 {} ", brands.getTotalElements(), brands.getTotalPages(), pageSize, pageNum);
		return commonResultPmsBrand;
	}

}
