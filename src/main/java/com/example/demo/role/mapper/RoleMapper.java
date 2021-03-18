package com.example.demo.role.mapper;

import com.example.demo.role.entity.RoleInfo;
import com.example.demo.role.entity.RoleUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    int countRoleId(@Param("roleId") String roleId);
    int addRole(RoleInfo roleInfo);
    int updateRole(RoleInfo roleInfo);
    int deleteRole(@Param("roleId") List<String> roleId);
    List<RoleInfo> listRole(Map<String,Object> param);

    int addRoleUser(@Param("userId") List<String> userId,@Param("roleId") String roleId);
    int deleteRoleUser(@Param("userId") List<String> userId,@Param("roleId") String roleId);

    List<RoleUserInfo> getUsersByRole(Map<String,Object> param);
}
