package com.example.demo.role.service;

import com.example.demo.role.entity.RoleInfo;
import com.example.demo.role.entity.RoleUserInfo;
import com.example.demo.util.AppResponse;

import java.util.List;

public interface RoleService {
    AppResponse addRole(RoleInfo roleInfo);
    AppResponse updateRole(RoleInfo roleInfo);
    AppResponse deleteRole(List<String> roleId);
    AppResponse listRole(RoleInfo roleInfo,Integer pageNo,Integer pageSize);
    AppResponse addRoleUser(List<String> userId,String roleId);
    AppResponse deleteRoleUser(List<String> userId,String roleId);
    AppResponse getUsersByRole(RoleUserInfo roleUserInfo,Integer pageNo,Integer pageSize);
}
