package com.example.demo.menu.service;

import com.example.demo.util.AppResponse;

import java.util.List;

public interface MenuService {
    /**
     * 列表查询菜单信息
     */
     AppResponse listMenu();
    /**
     * 为某一角色更新授权菜单
     */
    AppResponse updateRoleMenu(List<String> menuId,String roleId);
    /**
     * 查询某一角色的授权菜单
     */
    AppResponse getRoleMenu(String roleId);
    /**
     * 查询某一角色的授权叶子菜单
     */
    AppResponse getRoleMenuLeaf(String roleId);
}
