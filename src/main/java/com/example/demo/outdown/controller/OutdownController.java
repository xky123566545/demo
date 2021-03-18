package com.example.demo.outdown.controller;

import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.godown.service.GodownService;
import com.example.demo.outdown.entity.OutdownInfo;
import com.example.demo.outdown.service.OutdownService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(value = "出库单管理",description = "出库单管理",tags = {"出库单管理"})
@RequestMapping("/api1")
public class OutdownController {
    private static final Logger logger = LoggerFactory.getLogger(OutdownController.class);
    @Resource
    private OutdownService outdownService;

    /**
     * 新增入库单信息
     */
    @ApiOperation("新增出库单信息")
    @PostMapping("/addOutdown")
    public AppResponse addOutdown(@RequestBody OutdownInfo outdownInfo){
        try{
            return outdownService.addOutdown(outdownInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation("查询出库单信息")
    @PostMapping("listOutdown")
    public AppResponse listOutdown(@RequestBody OutdownInfo outdownInfo,
                                     @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                     @RequestParam(value = "pageSize",required = false) Integer pageSize) {
        try {
            pageNo = (pageNo == null) ? 1 : pageNo;
            pageSize = (pageSize == null) ? 20 : pageSize;
            return outdownService.listOutdown(outdownInfo, pageNo, pageSize);
        } catch (Exception e) {
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation(value = "修改出库单信息")
    @PostMapping("/updateOutdown")
    public AppResponse updateOutdown(@RequestBody OutdownInfo outdownInfo){
        try{
            return outdownService.updateOutdown(outdownInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation(value = "修改出库单状态")
    @PostMapping("/updateOutStatus")
    public AppResponse updateOutStatus(String outdownId,String status){
        try{
            return outdownService.updateOutStatus(outdownId,status);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
