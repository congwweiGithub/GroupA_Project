package com.mall.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PmsProductCategoryIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@Test // 通过
	public void testGetPmsProductCategory() throws Exception {
		// TODO
		ObjectMapper mapper = new ObjectMapper();
		CommonResult commonResult = CommonResult.builder()//
				.code(200l)//
				.data(pmsProductCategoryWithChildrenRepository.findAll())// 随便放点东西
				.message("ok").build();

		String json = mapper.writeValueAsString(commonResult);

		RequestBuilder request = MockMvcRequestBuilders//
				.get("/productCategory/list/withChildren")//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(content().json(json));

	}

}

//.andReturn()不报错都会通过
//andExpect用来检测简单的返回值及status。