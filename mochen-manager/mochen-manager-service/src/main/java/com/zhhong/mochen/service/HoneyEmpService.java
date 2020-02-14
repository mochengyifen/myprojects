package com.zhhong.mochen.service;

import com.zhhong.mochen.pojo.HoneyEmp;

/**
 * @author 董仁亮
 * @date 2020-01-13 20:13
 * @Description:
 */
public interface HoneyEmpService {

    /**
     * 登录
     *
     * @param empPhone
     * @param password
     * @return
     */
    HoneyEmp login(String empPhone, String password);
}
