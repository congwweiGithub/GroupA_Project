package com.mall.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.PmsProduct;

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
				.name("name")//
				.productCategoryName("productCategoryName")//
				.subTitle("subTitle")//
				.brandName("brandName")//
				.build();

		RequestBuilder request = MockMvcRequestBuilders//
				.post("/product/create")//
				.content(requsetBody.writeValueAsBytes(pmsProduct))//
//				.param("name", pmsProduct.getName())//
//				.param("productCategoryName", pmsProduct.getProductCategoryName())//
//				.param("subTitle", pmsProduct.getSubTitle())//
//				.param("brandName", pmsProduct.getBrandName())//
				.accept(MediaType.APPLICATION_JSON);

		String json = responseBody.writeValueAsString(pmsProduct);

		mockMvc.perform(request).andExpect(content().string(json));//准备个json    jackson

		ResultActions resultActions = mockMvc.perform(request);
		System.out.println("1111111111111111111111");
		System.out.println(resultActions.andReturn().getResponse().getContentAsString());

	}

	@Test // 待修改
	public void testCreateProduct_Failed1() throws Exception {
		PmsProduct pmsProduct = new PmsProduct();
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/create")//
				.param("name", "")//
				.param("productCategoryName", pmsProduct.getProductCategoryName())//
				.param("subTitle", pmsProduct.getSubTitle())//
				.param("brandName", pmsProduct.getBrandName())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(view().name("createFailed"));

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
