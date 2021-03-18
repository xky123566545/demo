package com.example.demo.role.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "role_user")
public class RoleUserInfo {
    /**
     * 角色编码
     */
    private String roleId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 状态 0使用 1作废
     */
    private String isDelete;
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 用户账号
     */
    private String userCode;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;


}
