package com.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.oms.OmsOrder;
import com.mall.model.response.CommonPage;
import com.mall.model.response.CommonResult;
import com.mall.repository.oms.OmsOrderRepository;

@RequestMapping("/order")
@Controller
public class OmsOrderController {

	@Autowired
	private OmsOrderRepository omsOrderRepository;

	@ResponseBody
	@GetMapping("/list")
	public CommonResult list(@RequestParam(name = "createTime", required = false) String createTime, //
			@RequestParam(name = "orderSn", required = false) String orderSn, //
			@RequestParam(name = "orderType", required = false) Integer orderType, //
			@RequestParam(name = "sourceType", required = false) Integer sourceType, //
			@RequestParam(name = "status", required = false) Integer status, //
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, //
			@RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize, //
			@RequestParam(name = "receiverKeyword", required = false) String receiverKeyword) {

		OmsOrder order;
		if (receiverKeyword == null) {
			order = OmsOrder.builder().createTime(createTime).orderSn(orderSn)//
					.orderType(orderType).sourceType(sourceType).status(status).build();
		} else if (receiverKeyword.matches("[0-9]{10,}")) {
			order = OmsOrder.builder().createTime(createTime).orderSn(orderSn)//
					.orderType(orderType).sourceType(sourceType).status(status)//
					.receiverPhone(receiverKeyword).build();
		} else {
			order = OmsOrder.builder().createTime(createTime).orderSn(orderSn)//
					.orderType(orderType).sourceType(sourceType).status(status)//
					.receiverName(receiverKeyword).build();
		}

		Example<OmsOrder> example = Example.of(order);
		List<OmsOrder> orders = omsOrderRepository.findAll(example);

		if (pageSize * pageNum < orders.size()) {
			orders = orders.subList(pageNum * pageSize - pageSize, pageNum * pageSize);
		}
		if (pageNum * pageSize >= orders.size() && pageNum * pageSize - pageSize != 0
				&& orders.size() > pageNum * pageSize - pageSize) {
			orders = orders.subList(pageNum * pageSize - pageSize, orders.size());
		}
		CommonPage<OmsOrder> commonPage = new CommonPage<>(orders, 0, 0, 0l, 0);
		return new CommonResult(200, commonPage, "ok");
	}

}