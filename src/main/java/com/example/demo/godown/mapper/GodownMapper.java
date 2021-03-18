package com.example.demo.godown.mapper;


import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.util.AppResponse;

import java.util.List;
import java.util.Map;

public interface GodownMapper {
    /**
     * 新增入库单信息
     */
    int addGodown(GodownInfo godownInfo);
    /**
     * 查询入库单信息
     */
    List<GodownInfo> listGodown(Map<String,Object> param);
    /**
     * 修改入库单信息
     */
    int updateGodown(GodownInfo godownInfo);
    /**
     * 修改入库单状态
     */
    int updateStatus(String godownId,String status);
}
