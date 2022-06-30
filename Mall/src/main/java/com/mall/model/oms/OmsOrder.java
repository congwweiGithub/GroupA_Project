
package com.mall.model.oms;

import java.sql.Date;

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
	private Date commentTime;
	private Integer confirmStatus;
	private Integer couponAmount;
	private Long couponId;
	private Date createTime;
	private Integer deleteStatus;
	private String deliveryCompany;
	private String deliverySn;
	private String deliveryTime;
	private Integer discountAmount;
	private Integer freightAmount;
	private Integer growth;
	private Integer integration;
	private Long memberId;
	private String memberUsername;
	private String modifyTime;
	private String note;
	private String orderSn;
	private Integer orderType;
	private Integer payAmount;
	private Integer payType;
	private String payTime;
	private Integer promotionAmount;
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
	private Integer totalAmount;
	private Integer useIntegration;
}