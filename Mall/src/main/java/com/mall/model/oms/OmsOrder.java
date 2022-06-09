package com.mall.model.oms;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class OmsOrder {
	@Id
	private Long id;
	
	private Integer autoConfirmDay; 
	private String billContent;
	private String billHeader;
	private String billReceiverEmail;
	private String billReceiverPhone;
	private Integer billType;
	private String commentTime;
	private Integer confirmStatus;
	private Number couponAmount;
	private Long couponId;
	private String createTime;
	private Integer deleteStatus;
	private String deliveryCompany;
	private String deliverySn;
	private String deliveryTime;
	private Number discountAmount;
	private Number freightAmount;
	private Integer growth;
	private Integer integration;
	private Long memberId;
	private String memberUsername;
	private String modifyTime;
	private String note;
	private String orderSn;
	private Integer orderType;
	private Number payAmount;
	private Integer payType;
	private String payTime;
	private Number promotionAmount;
	private String promotionInfo;
	private String receiveTime;
	private String receiverCity;
	private String receiverDetailAddress;
	private String receiverName;
	private String receiverPhone;
	private String receiverPostCode;
	private String receiveProvince;
	private String receiverRegion;
	private Integer sourceType;
	private Integer status;
	private Number totalAmount;
	private Integer useIntegration;
}
