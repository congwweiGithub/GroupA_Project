package com.mall.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.model.param.PmsProductCategoryParam;
import com.mall.model.pms.PmsProductCategory;
import com.mall.model.response.CommonResult;
import com.mall.repository.pms.PmsProductCategoryRepository;
import com.mall.repository.pms.PmsProductCategoryWithChildrenRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // 每个测试方法运行前会重启一次数据库并初始化数据库（可用于方法和类中）
public class PmsProductCategoryIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	PmsProductCategoryWithChildrenRepository pmsProductCategoryWithChildrenRepository;

	@Autowired
	PmsProductCategoryRepository pmsProductCategoryRepository;

	@Test // 通过
	public void testGetProductListCategoryWithChildren_succcess() throws Exception {

		// 常规操作需要先在test方法中手动创建一条数据存入db，然后再在用get的结果与创建数据的对象进行比较；
		// 由于在data.sql文件中手写了多条商品分类信息，暂用.findAll（）方法从数据库中调取数据与get结果进行比较。
		// 最好测试下数据库为空的情况
		ObjectMapper mapper = new ObjectMapper();
		CommonResult commonResult = CommonResult.builder()//
				.code(200l)//
				.data(pmsProductCategoryWithChildrenRepository.findAll())// 常规此数需写入创建数据的对象
				.message("ok").build();
		String json = mapper.writeValueAsString(commonResult);

		RequestBuilder request = MockMvcRequestBuilders//
				.get("/productCategory/list/withChildren")//
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(content().json(json));

		log.info("查询结果 :{}", json);
	}

	@Test
	@Transactional

	public void testCreateProductCategory_succcess_parentIdIsNot0() throws Exception {
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
		log.info("添加请求信息 :{}", json);

		// 检验请求参数是否成功存入数据库
		// 按期望值新建一个PmsProductCategory对象
		List<PmsProductCategory> expectedCategoryList = new ArrayList<>();
		PmsProductCategory expectedCategory = new PmsProductCategory();
		expectedCategory.setId(1l); // 此处手动设置id值，与parentIdis0存在顺序关系，感觉有问题。
		expectedCategory.setLevel(1);
		expectedCategoryList.add(expectedCategory);
		BeanUtils.copyProperties(param, expectedCategory);
		ObjectMapper mapper1 = new ObjectMapper();
		String expected = mapper1.writeValueAsString(expectedCategoryList);
		log.info("添加请求信息 :{}", expected);

		// 从数据库抽取待检测的数据
		List<PmsProductCategory> actualCategoryList = pmsProductCategoryRepository.findByName("电子书");
		ObjectMapper mapper2 = new ObjectMapper();
		String actual = mapper2.writeValueAsString(actualCategoryList);
		log.info("添加请求信息 :{}", actual);

		// 比较期待值与从db中抽取值是否一致
		assertEquals(expected, actual);// assertisnotnull; 然后再比较一些重要的内容，不必比较全部

	}

	@Test
	@Transactional

	public void testCreateProductCategory_succcess_parentIdIs0() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PmsProductCategoryParam param = PmsProductCategoryParam.builder().description("description")//
				.description(null)//
				.icon(null)//
				.keywords(null)//
				.name("保健品")//
				.navStatus(null)//
				.parentId(0l)//
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
		log.info("添加请求信息 :{}", json);

		// 检验请求参数是否成功存入数据库
		// 按期望值新建一个PmsProductCategory对象
		List<PmsProductCategory> expectedCategoryList = new ArrayList<>();
		PmsProductCategory expectedCategory = new PmsProductCategory();
		expectedCategory.setId(1l); // 此处手动设置id值，与parentIdis1存在顺序关系，感觉有问题。
		expectedCategory.setLevel(0);
		expectedCategoryList.add(expectedCategory);
		BeanUtils.copyProperties(param, expectedCategory);
		ObjectMapper mapper1 = new ObjectMapper();
		String expected = mapper1.writeValueAsString(expectedCategoryList);
		log.info("添加请求信息 :{}", expected);

		// 从数据库抽取待检测的数据
		List<PmsProductCategory> actualCategoryList = pmsProductCategoryRepository.findByName("保健品");
		ObjectMapper mapper2 = new ObjectMapper();
		String actual = mapper2.writeValueAsString(actualCategoryList);
		log.info("添加请求信息 :{}", actual);

		// 比较期待值与从db中抽取值是否一致
		assertEquals(expected, actual);

	}

	@Test
//	@Transactional // 运行测试方法后不保留测试时产生的变化，可用于junit，与springboot test一起使用可能存在问题
	public void testCreateProductCategory_failed() throws Exception {

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
	// 添加parentId is0 的失败情况；
}