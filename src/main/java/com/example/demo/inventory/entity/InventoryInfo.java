package com.example.demo.inventory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "inventory_manage")
public class InventoryInfo {
    /**
     * 仓库编号
     */
    private String inventoryId;
    /**
     * 仓库名称
     */
    private String inventoryName;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 库存类型
     */
    private String inventoryType;
    /**
     * 库存描述
     */
    private String inventoryDescribe;
    /**
     * 规格
     */
    private String inventorySize;
    /**
     * 地址
     */
    private String inventoryAddress;
    /**
     * 库存详情
     */
    private String inventoryInfo;
    /**
     * 条形码
     */
    private String barcode;
    /**
     * 原价
     */
    private String inventoryOriPrice;
    /**
     * 现价
     */
    private String inventoryPrePrice;
    /**
     * 库存
     */
    private String inventoryCount;
    /**
     * 创建人
     */
    private String createUser;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     * z状态
     */
    private String status;
}
