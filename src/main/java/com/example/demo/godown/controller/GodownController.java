package com.example.demo.godown.controller;

import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.godown.service.GodownService;
import com.example.demo.inventory.entity.InventoryInfo;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "入库单管理",description = "入库单管理",tags = {"入库单管理"})
@RequestMapping("/api1")
public class GodownController {
    private static final Logger logger = LoggerFactory.getLogger(GodownController.class);
    @Resource
    private GodownService godownService;

    /**
     * 新增入库单信息
     */
    @ApiOperation("新增入库单信息")
    @PostMapping("/addGodown")
    public AppResponse addGodown(@RequestBody GodownInfo godownInfo){
        try{
            return godownService.addGodown(godownInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation("查询入库单信息")
    @PostMapping("listGodown")
    public AppResponse listGodown(@RequestBody GodownInfo godownInfo,
                                     @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                     @RequestParam(value = "pageSize",required = false) Integer pageSize) {
        try {
            pageNo = (pageNo == null) ? 1 : pageNo;
            pageSize = (pageSize == null) ? 20 : pageSize;
            return godownService.listGodown(godownInfo, pageNo, pageSize);
        } catch (Exception e) {
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation(value = "修改入库单信息")
    @PostMapping("/updateGodown")
    public AppResponse updateGodown(@RequestBody GodownInfo godownInfo){
        try{
            return godownService.updateGodown(godownInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation(value = "修改入库单状态")
    @PostMapping("/updateStatus")
    public AppResponse updateStatus(String godownId,String status){
        try{
            return godownService.updateStatus(godownId,status);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
