package com.example.demo.inventory.controller;

import com.example.demo.inventory.entity.InventoryInfo;
import com.example.demo.inventory.service.InventoryService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 库存管理
 */
@RestController
@Api(value = "库存信息管理",tags = {"库存信息管理"},description = "库存信息管理")
@RequestMapping("/api1")
public class InventoryController {
    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
    @Resource
    private InventoryService inventoryService;

    @ApiOperation("新增库存信息")
    @PostMapping("/saveInventory")
    public AppResponse saveInventory(@RequestBody InventoryInfo inventoryInfo){
        try{
            return inventoryService.saveInventory(inventoryInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation("查询库存信息")
    @PostMapping("listInventory")
    public AppResponse listInventory(@RequestBody InventoryInfo inventoryInfo,
                                    @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){
        try{
            pageNo = (pageNo == null)? 1 : pageNo;
            pageSize = (pageSize == null)? 20 : pageSize;
            return inventoryService.listInventory(inventoryInfo,pageNo,pageSize);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }

    }
    @ApiOperation(value = "修改库存信息")
    @PostMapping("/updateInventory")
    public AppResponse updateInventory(@RequestBody InventoryInfo inventoryInfo){
        try{
            return inventoryService.updateInventory(inventoryInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation(value = "删除库存信息")
    @PostMapping("/deleteInventory")
    public AppResponse deleteInventory(@RequestBody List<String> inventoryId){
        try{
            return inventoryService.deleteInventory(inventoryId);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
