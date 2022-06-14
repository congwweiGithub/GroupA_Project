package com.mall.controller;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PmsProductIT {

	@Autowired
	private MockMvc mockMvc;

	@Test //
	public void testCreateProduct_Succcess() throws Exception {

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
				.pmsProductLadder(new ArrayList<>())//
				.pmsSkuStock(new ArrayList<>())//
				.build();

		RequestBuilder request = MockMvcRequestBuilders//
				.post("http://localhost:8080/product/create")//
				.content(requsetBody.writeValueAsString(pmsProduct))//
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()); // TODO 此处需更改(status().isOk()).

	}

}
