package com.mall.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.oms.OmsOrder;
import com.mall.model.response.CommonPage;
import com.mall.model.response.CommonResult;
import com.mall.service.OmsOrderService;

@RequestMapping("/order")
@Controller
public class OmsOrderController {

	@Autowired
	OmsOrderService omsOrderService;

	@ResponseBody
	@GetMapping("/list")
	public CommonResult list(@RequestParam(name = "createTime", required = false) Date createTime, //
			@RequestParam(name = "orderSn", required = false) String orderSn, //
			@RequestParam(name = "orderType", required = false) Integer orderType, //
			@RequestParam(name = "sourceType", required = false) Integer sourceType, //
			@RequestParam(name = "status", required = false) Integer status, //
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, //
			@RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, //
			@RequestParam(name = "receiverKeyword", required = false) String receiverKeyword) {

		CommonPage<OmsOrder> commonPage = omsOrderService.findByOrderSn(pageNum, pageSize, orderSn);
		return new CommonResult(200, commonPage, "ok");
	}

}