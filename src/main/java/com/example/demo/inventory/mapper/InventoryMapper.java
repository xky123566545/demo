package com.example.demo.inventory.mapper;

import com.example.demo.inventory.entity.InventoryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface InventoryMapper {
    /**
     * 新增库存信息
     */
    int saveInventory(InventoryInfo inventoryInfo);
    /**
     * 查询库存是否存在
     */
    int countInventoryName(@Param("inventoryName") String inventoryName);
    /**
     * 叠加库存
     */
    int addInventoryCount(@Param("inventoryName") String inventoryName,@Param("inventoryCount") Integer inventoryCount);
    /**
     * 列表查询
     */
    List<InventoryInfo> listInventory(Map<String,Object> param);
    /**
     * 修改库存信息
     */
    int updateInventory(InventoryInfo inventoryInfo);
    /**
     * 删除库存信息
     */
    int deleteInventory(@Param("inventoryId") List<String> inventoryId);
}
