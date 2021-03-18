package com.example.demo.role.controller;

import com.example.demo.role.entity.RoleInfo;
import com.example.demo.role.service.RoleService;
import com.example.demo.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.List;

@RestController
@Api(value = "角色信息增删查改",description = "角色信息增删查改",tags = {"角色信息增删查改"})
@RequestMapping("/api1")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Resource
    private RoleService roleService;

    /**
     * 新增角色信息
     */
    @ApiOperation("新增角色信息")
    @PostMapping("/addRole")
    public AppResponse addRole(@RequestBody RoleInfo roleInfo){
        try{
            return roleService.addRole(roleInfo);
        }catch (Exception e){
            logger.error("新增失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 新增角色信息
     */
    @ApiOperation("修改角色信息")
    @PostMapping("/updateRole")
    public AppResponse updateRole(@RequestBody RoleInfo roleInfo){
        try{
            return roleService.updateRole(roleInfo);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除角色
     */
    @ApiOperation("删除角色")
    @PostMapping("/deleteRole")
    public AppResponse deleteRole(@RequestBody List<String> roleId){
        try{
            return roleService.deleteRole(roleId);
        }catch (Exception e){
            logger.error("修改失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    @ApiOperation("列表查询角色信息")
    @PostMapping("/listRole")
    public AppResponse listRole(@RequestBody RoleInfo roleInfo,
                                @RequestParam(value = "pageNO",required = false) Integer pageNO,
                                @RequestParam(value = "pageSize",required = false) Integer pageSize){
        pageNO = (pageNO == null)? 1 : pageNO;
        pageSize = (pageSize == null)? 20 : pageSize;
        return roleService.listRole(roleInfo,pageNO,pageSize);
    }
}
