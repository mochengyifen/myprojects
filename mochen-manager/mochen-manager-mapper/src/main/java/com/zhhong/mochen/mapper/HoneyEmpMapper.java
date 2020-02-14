package com.zhhong.mochen.mapper;


import com.zhhong.mochen.pojo.HoneyEmp;
import com.zhhong.mochen.pojo.HoneyEmpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HoneyEmpMapper {

    long countByExample(HoneyEmpExample example);

    int deleteByExample(HoneyEmpExample example);

    int deleteByPrimaryKey(String empid);

    int insert(HoneyEmp record);

    int insertSelective(HoneyEmp record);

    List<HoneyEmp> selectByExample(HoneyEmpExample example);

    HoneyEmp selectByPrimaryKey(String empid);

    int updateByExampleSelective(@Param("record") HoneyEmp record, @Param("example") HoneyEmpExample example);

    int updateByExample(@Param("record") HoneyEmp record, @Param("example") HoneyEmpExample example);

    int updateByPrimaryKeySelective(HoneyEmp record);

    int updateByPrimaryKey(HoneyEmp record);

    List<Map<String,Object>> selectEmpAll(@Param("empid") String empid, @Param("ids") List<String> organizationIdList, @Param("startRow") int startRow, @Param("pageSize") int pageSize, @Param("selectWhere") String selectWhere, @Param("icategoryName") String icategoryName);

    long selectEmpCount(@Param("empid") String empid, @Param("ids") List<String> organizationIdList, @Param("selectWhere") String selectWhere, @Param("icategoryName") String icategoryName);
}