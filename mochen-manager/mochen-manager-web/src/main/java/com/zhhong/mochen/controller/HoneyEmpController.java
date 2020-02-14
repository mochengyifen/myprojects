package com.zhhong.mochen.controller;

import com.aliyuncs.exceptions.ClientException;
import com.zhhong.mochen.MochenResult;
import com.zhhong.mochen.SmsUtil;
import com.zhhong.mochen.StatusCode;
import com.zhhong.mochen.YamlConfigurerUtil;
import com.zhhong.mochen.exception.MochenClientException;
import com.zhhong.mochen.pojo.HoneyEmp;
import com.zhhong.mochen.service.HoneyEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 董仁亮
 * @date 2020-01-13 20:22
 * @Description:
 */
@RestController
@RequestMapping("/emp")
@Slf4j
public class HoneyEmpController {

    @Autowired
    private HoneyEmpService honeyEmpService;

    @RequestMapping("/login")
    public MochenResult login(String empPhone, String password) {
        HoneyEmp honeyEmp = null;
        try {
            honeyEmp = honeyEmpService.login(empPhone, password);
        } catch (Exception e) {
            if (e instanceof MochenClientException) {
                return MochenResult.build(((MochenClientException) e).getCode(), e.getMessage());
            }
        }
        if (honeyEmp != null) {
            return MochenResult.build(StatusCode.CODE_SUCCESS, "登录成功");
        } else {
            return MochenResult.build(StatusCode.CODE_ERROR, "登录失败");
        }
    }

    @RequestMapping("/sendSms")
    public MochenResult sendSms(String empPhone, HttpServletRequest request) {
        String code = null;
        try {
            code = SmsUtil.sendSms(empPhone, request, YamlConfigurerUtil.getStrYmlVal("login"));
        } catch (ClientException e) {
            return MochenResult.build(StatusCode.CODE_ERROR, "验证码发送失败");
        }
        if (code != null) {
            return MochenResult.build(StatusCode.CODE_SUCCESS, "验证码发送成功",code);
        }
        return MochenResult.build(StatusCode.CODE_ERROR, "验证码发送失败");
    }

    @RequestMapping("/")
    public String login() {
        return "templates/login";
    }
}
