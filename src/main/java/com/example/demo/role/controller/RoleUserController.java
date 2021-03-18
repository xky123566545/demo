package com.example.demo.role.controller;

import com.example.demo.role.entity.RoleUserInfo;
import com.example.demo.role.service.RoleService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "角色用户信息增删查改",description = "角色用户信息增删查改",tags = {"角色用户信息增删查改"})
@RequestMapping("/api1")
public class RoleUserController {
    private static final Logger logger = LoggerFactory.getLogger(RoleUserController.class);

    @Resource
    private RoleService roleService;
    @ApiOperation("为某一角色添加用户")
    @PostMapping("/addRoleUser")
    public AppResponse addRoleUser(@RequestBody List<String> userId,String roleId){
        try{
            return roleService.addRoleUser(userId,roleId);
        }catch (Exception e){
            logger.error("添加失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation("为某一角色删除用户")
    @PostMapping("/deleteRoleUser")
    public AppResponse deleteRoleUser(@RequestBody List<String> userId,String roleId){
        try{
            return roleService.deleteRoleUser(userId,roleId);
        }catch (Exception e){
            logger.error("添加失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    @ApiOperation("按条件查询某一角色的授权用户列表")
    @PostMapping("/getUsersByRole")
    public AppResponse getUsersByRole(@RequestBody RoleUserInfo roleUserInfo,
                                      @RequestParam(value = "pageNo",required = false) Integer pageNo,
                                      @RequestParam(value = "pageSize",required = false) Integer pageSize){
        pageNo = (pageNo == null)? 1 : pageNo;
        pageSize = (pageSize == null)? 20 : pageSize;
        return roleService.getUsersByRole(roleUserInfo,pageNo,pageSize);
    }

}
