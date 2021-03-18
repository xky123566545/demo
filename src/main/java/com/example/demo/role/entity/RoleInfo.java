package com.example.demo.role.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "role")
public class RoleInfo {
    /**
     * 角色编号
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色状态 0使用 1作废
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
    /**
     * 创建人名字
     */
    private String createUserName;
}
