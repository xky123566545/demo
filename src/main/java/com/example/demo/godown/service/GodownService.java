package com.example.demo.godown.service;

import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.util.AppResponse;

public interface GodownService {
    /**
     * 新增入库单信息
     */
    AppResponse addGodown(GodownInfo godownInfo);
    /**
     * 查询入库单信息
     */
    AppResponse listGodown(GodownInfo godownInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改入库单信息
     */
    AppResponse updateGodown(GodownInfo godownInfo);
    /**
     * 修改入库单状态
     */
    AppResponse updateStatus(String godownId,String status);
}
