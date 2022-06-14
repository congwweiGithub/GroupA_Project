package com.mall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.model.oss.OssCallbackResult;
import com.mall.model.oss.OssPolicyResult;
import com.mall.model.response.CommonResult;
import com.mall.service.OssService;

@Controller
@RequestMapping("/aliyun/oss")
public class OssController {
	
	@Autowired
    private OssService ossService;
	
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult policy() {
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }
	
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }
}
