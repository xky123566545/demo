package com.example.demo.menu.controller;

import com.example.demo.menu.service.MenuService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(value = "菜单信息增删查改",description = "菜单信息增删查改",tags = {"菜单信息增删查改"})
@RequestMapping("/api1")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;

    @ApiOperation("列表查询菜单接口")
    @PostMapping("/listMenu")
    public AppResponse listMenu(){
        try{
            return menuService.listMenu();
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
