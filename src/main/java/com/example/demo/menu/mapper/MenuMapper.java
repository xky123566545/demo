package com.example.demo.menu.mapper;

import com.example.demo.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    /**
     * 查询菜单信息
     */
    List<MenuInfo> listMenu();
    /**
     * 为某一角色更新授权菜单
     */
    int deleteRoleMenu(@Param("roleId") String roleId);
    int updateRoleMenu(@Param("menuId") List<String> menuId,@Param("roleId") String roleId);
    /**
     * 查询某一角色的授权菜单
     */
    List<String> getRoleMenu(@Param("roleId") String roleId);
    /**
     * 查询某一角色的授权叶子菜单
     */
    List<String> getRoleMenuLeaf(@Param("roleId") String roleId);
}
