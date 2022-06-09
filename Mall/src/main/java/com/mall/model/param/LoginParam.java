package com.mall.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建 API 中规定的 umsAdminLoginParam 所具有的类型
 * 
 * @author aki
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

	private String password;
	private String username;
}