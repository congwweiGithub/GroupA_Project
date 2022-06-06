package com.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mall.model.OmsOrder;

public interface OmsOrderRepository extends JpaRepository<OmsOrder,Long>{
	
//	OmsOrder findByOrderId(Long orderId);

}
