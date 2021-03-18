package com.example.demo.outdown.service;

import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.outdown.entity.OutdownInfo;
import com.example.demo.util.AppResponse;

public interface OutdownService {
    /**
     * 新增出库单信息
     */
    AppResponse addOutdown(OutdownInfo outdownInfo);
    /**
     * 查询出库单信息
     */
    AppResponse listOutdown(OutdownInfo outdownInfo, Integer pageNo, Integer pageSize);
    /**
     * 修改出库单信息
     */
    AppResponse updateOutdown(OutdownInfo outdownInfo);
    /**
     * 修改出库单状态
     */
    AppResponse updateOutStatus(String oudownId, String status);
}
