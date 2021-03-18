package com.example.demo.outdown.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "outdown")
public class OutdownInfo {
    /**
     * 出库单编号
     */
    private String outdownId;
    /**
     * 出库单名称
     */
    private String inventoryName;
    /**
     * 图片路径
     */
    private String imgPath;
    /**
     * 顾客名字
     */
    private String customerName;
    /**
     * 顾客电话
     */
    private String customerPhone;
    /**
     * 顾客地址
     */
    private String customerAddress;
    /**
     * 条形码
     */
    private String barcode;
    /**
     * 出货价
     */
    private String outdownPrice;

    /**
     * 数量
     */
    private String outdownCnt;
    /**
     * 总价
     */
    private String outdownAllPrice;
    /**
     * 创建人
     */
    private String createUser;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     * 状态 0已出库，1已发货
     */
    private String status;
    /**
     *出库时间
     */
    private Date outdownTime;
    /**
     * 仓库编号
     */
    private String inventoryId;
}
