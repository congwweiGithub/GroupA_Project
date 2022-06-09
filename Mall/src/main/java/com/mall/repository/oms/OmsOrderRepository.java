package com.mall.repository.oms;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mall.model.oms.OmsOrder;


public interface OmsOrderRepository extends JpaRepository<OmsOrder, Long> {
	
	@Query("SELECT * FROM oms_order WHERE create_time = createTime AND order_sn = orderSn AND order_type = orderType AND source_type = sourceType AND status = Status AND receiver_name = receiverName")
	List<OmsOrder> findAllByContrainsAndName(@Param("createTime")String createTime,//
			@Param("orderSn")String orderSn, @Param("orderType")Integer orderType,//
			@Param("sourceType")Integer sourceType, @Param("Status")Integer status,//
			@Param("receiverName")String receiverName);
	
	@Query("SELECT * FROM oms_order WHERE create_time = createTime AND order_sn = orderSn AND order_type = orderType AND source_type = sourceType AND status = Status AND receiver_phone = receiverPhone")
	List<OmsOrder> findAllByContrainsAndPhone(@Param("createTime")String createTime,//
			@Param("orderSn")String orderSn, @Param("orderType")Integer orderType,//
			@Param("sourceType")Integer sourceType, @Param("Status")Integer status,//
			@Param("receiverPhone")String receiverPhone);
	
	@Query("SELECT * FROM oms_order WHERE create_time = createTime AND order_sn = orderSn AND order_type = orderType AND source_type = sourceType AND status = Status")
	List<OmsOrder> findAllByContrains(@Param("createTime")String createTime,//
			@Param("orderSn")String orderSn, @Param("orderType")Integer orderType,//
			@Param("sourceType")Integer sourceType, @Param("Status")Integer status);
	
}
