package com.mall.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.param.PmsProductParam;
import com.mall.model.pms.PmsProduct;
import com.mall.repository.pms.PmsProductRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PmsProductIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PmsProductRepository pmsProductRepository;

	@Test //
	public void testCreateProduct_Succcess() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		PmsProductParam param = PmsProductParam.builder()//
				.id(1l)//
				.albumPics("albumPics")//
				.icon("icon")//
				.brandId(2l)//
				.brandName("brandName")//
				.deleteStatus(1)//
				.description("description")//
				.detailDesc("detailDesc")//
				.detailHtml("detailHtml")//
				.detailMobileHtml("detailMobileHtml")//
				.detailTitle("detailTitle")//
				.feightTemplateId(2l)//
				.giftGrowth(1)//
				.giftPoint(1)//
				.keyWords("keyWords")//
				.lowStock(1)//
				.name("魅族手机")//
				.newStatus(1)//
				.note("note")//
				.originalPrice(1.00)//
				.pic("pic")//
				.previewStatus(1)//
				.price(1.0)//
				.productAttributeCategoryId(2l)//
				.productCategoryId(2l)//
				.productCategoryName("productCategoryName")//
				.productSn("productSn")//
				.promotionEndTime(new Timestamp(new Date().getTime()))//
				.promotionPerLimit(1)//
				.promotionPrice(1.0)//
				.promotionStartTime(new Timestamp(new Date().getTime()))//
				.promotionType(1)//
				.publishStatus(1)//
				.recommandStatus(1)//
				.sale(1)//
				.serviceIds("serviceIds")//
				.sort(1)//
				.stock(1)//
				.subTitle("subTitle")//
				.unit("unit")//
				.usePointLimit(1)//
				.verifyStatus(1)//
				.weight(1.0)//
				.cmsPrefrenceAreaProductRelation(new ArrayList<>())//
				.cmsSubjectProductRelation(new ArrayList<>())//
				.pmsMemberPrice(new ArrayList<>())//
				.pmsProductAttributeValue(new ArrayList<>())//
				.pmsProductFullReduction(new ArrayList<>())//
				.pmsProductLadder(new ArrayList<>())//
				.pmsSkuStock(new ArrayList<>())//
				.build();
		String json1 = mapper.writeValueAsString(param);
		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.accept(MediaType.APPLICATION_JSON)//
				.contentType(MediaType.APPLICATION_JSON)//
				.content(json1.getBytes())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)//
				.andExpect(jsonPath("$.code", is(200)))//
				.andExpect(jsonPath("$.message", is("通信成功"))); // TODO

		List<PmsProduct> product = pmsProductRepository.findByName("小米手机");

		ObjectMapper mapper2 = new ObjectMapper();
		String json2 = mapper2.writeValueAsString(product);
		assertEquals("[" + json1 + "]", json2);
	}

	@Test //
	public void testCreateProduct_Failed() throws Exception {

		PmsProductParam saveParam = new PmsProductParam();
		PmsProduct pmsProduct = new PmsProduct();
		BeanUtils.copyProperties(saveParam, pmsProduct);
		pmsProduct.setName("小米手机");
		pmsProductRepository.save(pmsProduct);

		ObjectMapper mapper = new ObjectMapper();
		PmsProductParam param = PmsProductParam.builder()//
				.id(1l).albumPics("albumPics")//
				.icon("icon")//
				.brandId(2l)//
				.brandName("brandName")//
				.deleteStatus(1)//
				.description("description")//
				.detailDesc("detailDesc")//
				.detailHtml("detailHtml")//
				.detailMobileHtml("detailMobileHtml")//
				.detailTitle("detailTitle")//
				.feightTemplateId(2l)//
				.giftGrowth(1)//
				.giftPoint(1)//
				.keyWords("keyWords")//
				.lowStock(1)//
				.name("小米手机")//
				.newStatus(1)//
				.note("note")//
				.originalPrice(1.00)//
				.pic("pic")//
				.previewStatus(1)//
				.price(1.0)//
				.productAttributeCategoryId(2l)//
				.productCategoryId(2l)//
				.productCategoryName("productCategoryName")//
				.productSn("productSn")//
				.promotionEndTime(new Timestamp(new Date().getTime()))//
				.promotionPerLimit(1)//
				.promotionPrice(1.0)//
				.promotionStartTime(new Timestamp(new Date().getTime()))//
				.promotionType(1)//
				.publishStatus(1)//
				.recommandStatus(1)//
				.sale(1)//
				.serviceIds("serviceIds")//
				.sort(1)//
				.stock(1)//
				.subTitle("subTitle")//
				.unit("unit")//
				.usePointLimit(1)//
				.verifyStatus(1)//
				.weight(1.0)//
				.cmsPrefrenceAreaProductRelation(new ArrayList<>())//
				.cmsSubjectProductRelation(new ArrayList<>())//
				.pmsMemberPrice(new ArrayList<>())//
				.pmsProductAttributeValue(new ArrayList<>())//
				.pmsProductFullReduction(new ArrayList<>())//
				.pmsProductLadder(new ArrayList<>())//
				.pmsSkuStock(new ArrayList<>())//
				.build();
		String json = mapper.writeValueAsString(param);
		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.accept(MediaType.APPLICATION_JSON)//
				.contentType(MediaType.APPLICATION_JSON)//
				.content(json.getBytes())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)//
				.andExpect(jsonPath("$.code", is(201)))//
				.andExpect(jsonPath("$.message", is("通信失败")));

	}

}
