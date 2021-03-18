package com.example.demo.outdown.mapper;


import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.outdown.entity.OutdownInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OutdownMapper {
    /**
     * 修改仓库库存
     */
    int updateCnt(@Param("inventoryId") String inventoryId,@Param("cnt") Integer cnt);
    /**
     * 新增出库单信息
     */
    int addOutdown(OutdownInfo outdownInfo);
    /**
     * 查询出库单信息
     */
    List<OutdownInfo> listOutdown(Map<String, Object> param);
    /**
     * 修改出库单信息
     */
    int updateOutdown(OutdownInfo outdownInfo);
    /**
     * 修改出库单状态
     */
    int updateOutStatus(@Param("outdownId") String outdownId,@Param("status") String status);
}
