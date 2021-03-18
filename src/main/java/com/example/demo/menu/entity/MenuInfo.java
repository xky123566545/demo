package com.example.demo.menu.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "menu")
public class MenuInfo {
    /**
     * 菜单编号
     */
    private String menuId;
    /**
     * 菜单名字
     */
    private String menuName;
    /**
     * 菜单父菜单
     */
    private String menuParentId;
    /**
     * 菜单状态
     */
    private String menuStatus;
    /**
     * 是否叶节点  0为父节点 1为叶子节点
     */
    private String isLeaf;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 备注
     */
    private String remark;
    private List<MenuInfo> children;
}
