package com.mall.controller;

import javax.annotation.Resource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mall.MallApplication;

@SpringBootTest(classes = {MallApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//classes:入口类，webEnvironment配置环境参数：随机获取端口进行测试避免撞车 
@AutoConfigureMockMvc
public class PmsBrandControllerTest {

	//private Logger logger = Logger.getLogger(PmsBrandControllerTest.class.toString());

	@Resource
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("GetBrandList")
	public void brandListTest() throws Exception {

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/brand/list"))//让mockmvc执行一个创建get方法的行为
		.andExpect(MockMvcResultMatchers.status().isOk())//期望值：预期返回码为200（成功），该方法单单判断是否可以访问得到（通过状态值判断）
		.andDo(MockMvcResultHandlers.print())//做点啥：如果上面expected的为200，则print内容
		.andExpect(MockMvcResultMatchers.content().json(null))///期望值：content:针对请求体进行数据判断,string:判断返回信息和string内容是否相符（若不匹配则会产生断言说明不匹配）
		.andReturn();//真正返回的内容
		
	}
	
	@Test
	//@DisplayName("PostCreateBrandJSON")
	public void createBrandTest() throws Exception {
		
		List<String> list = new ArrayList<String>();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/create")//
				.header("", "")//
				.param("", ""))//
		.andExpect(MockMvcResultMatchers.status().isOk())//
		.andDo(MockMvcResultHandlers.print())//
		.andExpect(MockMvcResultMatchers//
				.jsonPath("")//
				.value(""))//期望值
		.andReturn();
					
	}
}

//@BeforeEach
//public void setUp() throws Exception {
//
//}
//
//@BeforeAll
//public static void setUpBeforeClass() throws Exception {
//
//}
//
//@AfterEach
//public void tearDown() throws Exception {
//
//}
//
//@AfterAll
//public static void tearDownAfterClass() throws Exception {
//
//}