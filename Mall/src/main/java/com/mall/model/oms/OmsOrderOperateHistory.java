package com.mall.model.oms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class OmsOrderOperateHistory {

	// JPA多对一
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oms_order_id")
	private OmsOrder omsOrder;

	@Id
	@GeneratedValue
	private Long id;

	private Date createTime;
	// 操作时间

	private String note;
	// 备注

	private String operateMan;
	// 操作人：用户；系统；后台管理员

	private Long orderId;
	// 订单id

	private int orderStatus;
	// 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单

}
