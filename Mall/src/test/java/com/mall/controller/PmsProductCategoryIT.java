package com.mall.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
import com.mall.model.param.PmsProductCategoryParam;
import com.mall.model.pms.PmsProductCategory;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryRepository;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@Slf4j
public class PmsProductCategoryIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@Autowired
	PmsProductCategoryRepository pmsProductCategoryRepository;

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

	@Test
	public void testCreateProductCategory_Succcess() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PmsProductCategoryParam param = PmsProductCategoryParam.builder().description("description")//
				.description(null)//
				.icon(null)//
				.keywords(null)//
				.name("电子书")//
				.navStatus(null)//
				.parentId(20l)//
				.productUnit(null)//
				.showStatus(null)//
				.sort(null)//
				.build();

		String json = mapper.writeValueAsString(param);
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/productCategory/create")//
				.contentType(MediaType.APPLICATION_JSON)//
				.content(json.getBytes())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(jsonPath("$.code", is(200)))//
				.andExpect(jsonPath("$.message", is("通信成功")));

		// TODO 比较请求参数是否成功存入数据库
//		List<PmsProductCategory> category = pmsProductCategoryRepository.findByName("电子辞典");
//		log.info("添加请求信息 :{}", json);
//		ObjectMapper mapper1 = new ObjectMapper();
//		String json2 = mapper1.writeValueAsString(category);
//		log.info("商品分类信息 :{}", json2);
//		assertEquals("[" + json + "]", json2);

	}

	@Test
	public void testCreateProductCategory_Failed() throws Exception {

		PmsProductCategoryParam saveParam = new PmsProductCategoryParam();
		PmsProductCategory pmsProductCategory = new PmsProductCategory();
		BeanUtils.copyProperties(saveParam, pmsProductCategory);
		pmsProductCategory.setName("电子辞典");
		pmsProductCategoryRepository.save(pmsProductCategory);

		ObjectMapper mapper = new ObjectMapper();
		PmsProductCategoryParam param = PmsProductCategoryParam.builder().description("description")//
				.description(null)//
				.icon(null)//
				.keywords(null)//
				.name("电子辞典")//
				.navStatus(null)//
				.parentId(20l)//
				.productUnit(null)//
				.showStatus(null)//
				.sort(null)//
				.build();

		String json = mapper.writeValueAsString(param);
		RequestBuilder request = MockMvcRequestBuilders//
				.post("/productCategory/create")//
				.contentType(MediaType.APPLICATION_JSON)//
				.content(json.getBytes())//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(jsonPath("$.code", is(201)))//
				.andExpect(jsonPath("$.message", is("通信失败")));

	}
}