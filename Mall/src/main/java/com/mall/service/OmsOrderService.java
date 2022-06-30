package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mall.model.oms.OmsOrder;
import com.mall.model.response.CommonPage;
import com.mall.repository.oms.OmsOrderRepository;

@Service
public class OmsOrderService {

	@Autowired
	OmsOrderRepository omsOrderRepository;

	public CommonPage<OmsOrder> findByOrderSn(Integer pageNum, Integer pageSize, String ordersn) {

		CommonPage<OmsOrder> commonPage;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		List<OmsOrder> orderList;
		Page<OmsOrder> order;

		if (ordersn == null) {
			order = omsOrderRepository.findAll(pageable);
		} else {
			order = omsOrderRepository.findByOrderSn(pageable, (ordersn));
		}
		orderList = order.getContent();

		commonPage = new CommonPage<OmsOrder>(orderList, pageNum, pageSize, order.getTotalElements(),
				order.getTotalPages());
		return commonPage;
	}

}
