package com.example.demo.godown.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "godown")
public class GodownInfo {
    /**
     * 入库单编号
     */
    private String godownId;
    /**
     * 入库单名称
     */
    private String godownName;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 入库单类型
     */
    private String godownType;
    /**
     * 入库单描述
     */
    private String godownDescribe;
    /**
     * 规格
     */
    private String godownSize;
    /**
     * 地址
     */
    private String godownAddress;
    /**
     * 入库单详情
     */
    private String godownInfo;
    /**
     * 条形码
     */
    private String barcode;
    /**
     * 原价
     */
    private String godownOriPrice;
    /**
     * 现价
     */
    private String godownPrePrice;
    /**
     * 数量
     */
    private String godownCount;
    /**
     * 创建人
     */
    private String createUser;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     * 状态 0未入库 1已入库 2取消
     */
    private String status;
    /**
     *入库时间
     */
    private Date godownTime;
}
