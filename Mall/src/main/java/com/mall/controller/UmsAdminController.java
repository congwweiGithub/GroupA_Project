package com.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RequestMapping("/admin") // 所有本类中方法的请求路径都以 /admin 开头
@Controller
public class UmsAdminController {
	// Logger 用于记录服务器日志
	private static final Logger logger = LoggerFactory.getLogger(UmsAdminController.class);

	// 创建 API 中规定的 umsAdminLoginParam 所具有的类型
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class LoginParam {
		private String password;
		private String username;
	}

	// 创建 API 中规定的 response 所具有的类型
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Response {
		private long code;
		private Object data;
		private String message;
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/login") // 因为在类前注释了“@RequestMapping("/admin")”，只需要写 /admin 之后的路径
	
	public Response login(@RequestBody LoginParam param) { // 传入参数为 RequestBody （在文档中标识为 body）
		if (param.getPassword().equals("123") && param.getUsername().equals("abc")) {
			logger.info("User " + param.getUsername() + " logged in.");
			return new Response(200, null, "Succeed");
		} else {
			logger.warn("user " + param.getUsername() + " failed to log in.");
			return new Response(404, null, "Fail");
		}
	}

	@ResponseBody
	@PostMapping("/logout")
	public Response logout() {
		logger.info("User logged out");
		return new Response(200, null, "Succeed");
	}

	@ResponseBody
	@GetMapping("/info")
	public Response info(@RequestParam String name) { // 传入参数为 RequestHeader 中的 parameter （在文档中标识为 query）
		logger.info("Getting user " + name + "'s information...");
		return new Response(200, name + "'s info", "Succeed");
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Response info(@PathVariable Long id) { // 直接通过路径传入参数 （在文档中标识为 path）
		logger.info("Getting user " + id + "'s information...");
		return new Response(200, id + "'s info", "Succeed");
	}
}
