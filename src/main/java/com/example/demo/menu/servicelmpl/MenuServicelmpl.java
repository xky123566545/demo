package com.example.demo.menu.servicelmpl;

import com.example.demo.menu.entity.MenuInfo;
import com.example.demo.menu.mapper.MenuMapper;
import com.example.demo.menu.service.MenuService;
import com.example.demo.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServicelmpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public AppResponse listMenu() {
        List<MenuInfo> menuInfos = menuMapper.listMenu();
        List<MenuInfo> treeList = buildMenuTree(menuInfos);
        return AppResponse.success("查询成功",treeList);
    }

    @Override
    public AppResponse updateRoleMenu(List<String> menuId, String roleId) {
        menuMapper.deleteRoleMenu(roleId);
        if (menuMapper.updateRoleMenu(menuId,roleId) == 0){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功");
    }

    @Override
    public AppResponse getRoleMenu(String roleId) {
        List<String> menu = menuMapper.getRoleMenu(roleId);
        if (menu == null){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功",menu);
    }

    @Override
    public AppResponse getRoleMenuLeaf(String roleId) {
        List<String> menu = menuMapper.getRoleMenuLeaf(roleId);
        if (menu == null){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功",menu);
    }

    private List<MenuInfo> buildMenuTree(List<MenuInfo> menuList) {
        List<MenuInfo> treeList = new ArrayList<MenuInfo>();
        for(MenuInfo menu: menuList) {
            if ("0".equals(menu.getIsLeaf())) {
                List<MenuInfo> childList = getChildren(menu.getMenuId(), menuList);
                menu.setChildren(childList);
                treeList.add(menu);
            }
        }
        return treeList;
    }
    private List<MenuInfo> getChildren(String menuId, List<MenuInfo> menuList){
        List<MenuInfo> childrenList = new ArrayList<MenuInfo>();
        for(MenuInfo menu : menuList){
            if (null!=menu.getMenuParentId() && menu.getMenuParentId().equals(menuId)){
                menu.setChildren(getChildren(menu.getMenuId(),menuList));
                childrenList.add(menu);
            }
        }
        return childrenList;
    }
}
