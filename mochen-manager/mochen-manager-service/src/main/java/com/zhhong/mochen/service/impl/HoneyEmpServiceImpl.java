package com.zhhong.mochen.service.impl;

import com.zhhong.mochen.mapper.HoneyEmpMapper;
import com.zhhong.mochen.pojo.HoneyEmp;
import com.zhhong.mochen.pojo.HoneyEmpExample;
import com.zhhong.mochen.service.HoneyEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 董仁亮
 * @date 2020-01-13 20:13
 * @Description:
 */
@Service
public class HoneyEmpServiceImpl implements HoneyEmpService {
    @Autowired
    private HoneyEmpMapper honeyEmpMapper;

    public HoneyEmp login(String empPhone, String password) {
        HoneyEmpExample empExample = new HoneyEmpExample();
        empExample.or().andEmpphoneEqualTo(empPhone).andPasswordEqualTo(password);
        List<HoneyEmp> honeyEmpList = honeyEmpMapper.selectByExample(empExample);
        if (honeyEmpList.size() > 0) {
            return honeyEmpList.get(0);
        }
        return null;
    }
}
