package com.example.demo.inventory.service;

import com.example.demo.inventory.entity.InventoryInfo;
import com.example.demo.util.AppResponse;

import java.util.List;

public interface InventoryService {
    /**
     * 新增库存信息
     */
    AppResponse saveInventory(InventoryInfo inventoryInfo);
    /**
     * 列表查询库存信息
     */
    AppResponse listInventory(InventoryInfo inventoryInfo,Integer pageNo,Integer pageSize);
    /**
     * 修改库存信息
     */
    AppResponse updateInventory(InventoryInfo inventoryInfo);
    /**
     * 删除库存信息
     */
    AppResponse deleteInventory(List<String> inventoryId);
}
