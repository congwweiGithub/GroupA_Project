package com.mall.repository.oms;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mall.model.oms.OmsOrder;


public interface OmsOrderRepository extends JpaRepository<OmsOrder, Long> {
	
	
}
