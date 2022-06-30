package com.mall.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mall.model.response.CommonResultPmsBrand;

@SpringBootTest
class PmsBrandServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Resource
	CommonResultPmsBrand commonResultPmsBrand;
	PmsBrandService pmsBrandService;

	@Test
	void testFindRequiredBrand() {
		commonResultPmsBrand = pmsBrandService.findRequiredBrands(null, null, null);
		Assert.
		
		fail("Not yet implemented");
	}

}
