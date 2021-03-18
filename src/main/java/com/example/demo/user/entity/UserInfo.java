package com.example.demo.user.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@ApiModel(value = "用户实体类",description = "对应用户表")
@Table(name = "user")
public class UserInfo {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
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
