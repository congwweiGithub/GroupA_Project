package com.mall.controller;

<<<<<<< Upstream, based on main
//import static org.junit.Assert.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.pms.PmsProduct;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.PmsProduct;
>>>>>>> 07b061a 编写代码

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PmsProductITest {

	@Autowired
	private MockMvc mockMvc;

	@Test //
	public void testCreateProduct_Succcess() throws Exception {

		ObjectMapper responseBody = new ObjectMapper();
		ObjectMapper requsetBody = new ObjectMapper();
		PmsProduct pmsProduct = PmsProduct.builder()//
				.id(2l).albumPics("albumPics")//
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
				.name("name")//
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

		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.content(requsetBody.writeValueAsString(pmsProduct))//
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		String json = responseBody.writeValueAsString(pmsProduct);

		mockMvc.perform(request).andExpect(status().isOk());

	}

	@Test // TODO
	public void testCreateProduct_Failed_NameisEmpyt() throws Exception {
		ObjectMapper responseBody = new ObjectMapper();
		ObjectMapper requsetBody = new ObjectMapper();
		PmsProduct pmsProduct = PmsProduct.builder()//
				.id(1l).albumPics("albumPics")//
				.icon("icon")//
				.brandId(1l)//
				.brandName("brandName")//
				.deleteStatus(1)//
				.description("description")//
				.detailDesc("detailDesc")//
				.detailHtml("detailHtml")//
				.detailMobileHtml("detailMobileHtml")//
				.detailTitle("detailTitle")//
				.feightTemplateId(1l)//
				.giftGrowth(1)//
				.giftPoint(1)//
				.keyWords("keyWords")//
				.lowStock(1)//
				.name(null)//
				.newStatus(1)//
				.note("note")//
				.originalPrice(1.00)//
				.pic("pic")//
				.previewStatus(1)//
				.price(1.0)//
				.productAttributeCategoryId(1l)//
				.productCategoryId(1l)//
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

		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.content(requsetBody.writeValueAsString(pmsProduct))//
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isBadRequest());
	}

	@Test // TODO
	public void testCreateProduct_Failed2() throws Exception {
		PmsProduct pmsProduct = new PmsProduct();
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/create")//
				.param("name", pmsProduct.getName())//
				.param("productCategoryName", "")//
				.param("subTitle", pmsProduct.getSubTitle())//
				.param("brandName", pmsProduct.getBrandName())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(view().name("createFailed"));

	}

	@Test // TODO
	public void testCreateProduct_Failed3() throws Exception {
		PmsProduct pmsProduct = new PmsProduct();
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/create")//
				.param("name", pmsProduct.getName())//
				.param("productCategoryName", pmsProduct.getProductCategoryName())//
				.param("subTitle", "")//
				.param("brandName", pmsProduct.getBrandName())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(view().name("createFailed"));

	}

	@Test // TODO
		ObjectMapper requsetBody = new ObjectMapper();		
		PmsProduct pmsProduct = PmsProduct.builder()//
				
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
				.name("name")//
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
				//.pmsProductLadder(new ArrayList<>())//
				.pmsProductLadder(new ArrayList<>())
				.pmsSkuStock(new ArrayList<>())//				
				.build();

		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.content(requsetBody.writeValueAsString(pmsProduct))//	
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

//		String json = responseBody.writeValueAsString(pmsProduct);
		
		mockMvc.perform(request).andExpect(status().isOk());		
//		assertEquals(json, request.toString());  // 过后再写
//		mockMvc.perform(request).andExpect(content().string(json));

//		ResultActions resultActions = mockMvc.perform(request);
//		System.out.println("1111111111111111111111");
//		System.out.println(resultActions);
//		System.out.println(resultActions.andReturn().getResponse().getContentAsString());

	}

	@Test // 待修改
	public void testCreateProduct_Failed_NameisEmpyt() throws Exception {
		ObjectMapper responseBody = new ObjectMapper();
		ObjectMapper requsetBody = new ObjectMapper();		
		PmsProduct pmsProduct = PmsProduct.builder()//
				.id(1l)
				.albumPics("albumPics")//
				.icon("icon")//
				.brandId(1l)//
				.brandName("brandName")//
				.deleteStatus(1)//
				.description("description")//
				.detailDesc("detailDesc")//
				.detailHtml("detailHtml")//
				.detailMobileHtml("detailMobileHtml")//
				.detailTitle("detailTitle")//
				.feightTemplateId(1l)//
				.giftGrowth(1)//
				.giftPoint(1)//
				.keyWords("keyWords")//
				.lowStock(1)//
				.name(null)//
				.newStatus(1)//
				.note("note")//
				.originalPrice(1.00)//
				.pic("pic")//
				.previewStatus(1)//
				.price(1.0)//
				.productAttributeCategoryId(1l)//
				.productCategoryId(1l)//
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

		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.content(requsetBody.writeValueAsString(pmsProduct))//	
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

//		String json = responseBody.writeValueAsString(pmsProduct);
		
		mockMvc.perform(request).andExpect(status().isBadRequest());
	}

	@Test // 待修改
	public void testCreateProduct_Failed2() throws Exception {
		PmsProduct pmsProduct = new PmsProduct();
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/create")//
				.param("name", pmsProduct.getName())//
				.param("productCategoryName", "")//
				.param("subTitle", pmsProduct.getSubTitle())//
				.param("brandName", pmsProduct.getBrandName())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(view().name("createFailed"));

	}

	@Test // 待修改
	public void testCreateProduct_Failed3() throws Exception {
		PmsProduct pmsProduct = new PmsProduct();
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/create")//
				.param("name", pmsProduct.getName())//
				.param("productCategoryName", pmsProduct.getProductCategoryName())//
				.param("subTitle", "")//
				.param("brandName", pmsProduct.getBrandName())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(view().name("createFailed"));

	}

	@Test // 待修改
>>>>>>> 07b061a 编写代码
	public void testCreateProduct_Failed4() throws Exception {
		PmsProduct pmsProduct = new PmsProduct();
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/create")//
				.param("name", pmsProduct.getName())//
				.param("productCategoryName", pmsProduct.getProductCategoryName())//
				.param("subTitle", pmsProduct.getSubTitle())//
				.param("brandName", "")//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(view().name("createFailed"));

	}

}
