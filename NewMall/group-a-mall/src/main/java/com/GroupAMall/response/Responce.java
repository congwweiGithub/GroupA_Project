package com.GroupAMall.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//创建 API 中规定的 response 所具有的类型
public class Responce {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Response {
		private long code;
		private Object data;
		private String message;
	}

}
