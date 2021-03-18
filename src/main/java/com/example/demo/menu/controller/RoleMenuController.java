package com.example.demo.menu.controller;

import com.example.demo.menu.service.MenuService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "角色菜单信息接口",tags = {"角色菜单信息接口"})
@RequestMapping("/api1")
public class RoleMenuController {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);
    @Resource
    private MenuService menuService;

    @ApiOperation("为某一角色更新授权菜单")
    @PostMapping("/updateRoleMenu")
    public AppResponse updateRoleMenu(@RequestBody List<String> menuId,String roleId){
        try{
            return menuService.updateRoleMenu(menuId,roleId);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation("查询某一角色的授权菜单")
    @PostMapping("/getRoleMenu")
    public AppResponse getRoleMenu(String roleId){
        try{
            return menuService.getRoleMenu(roleId);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation("查询某一角色的授权叶子菜单")
    @PostMapping("/getRoleMenuLeaf")
    public AppResponse getRoleMenuLeaf(String roleId){
        try{
            return menuService.getRoleMenuLeaf(roleId);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
