package com.example.demo.role.servicelmpl;

import com.example.demo.role.entity.RoleInfo;
import com.example.demo.role.entity.RoleUserInfo;
import com.example.demo.role.mapper.RoleMapper;
import com.example.demo.role.service.RoleService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServicelmpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public AppResponse addRole(RoleInfo roleInfo) {
        //查看角色编号是否存在
        if (roleMapper.countRoleId(roleInfo.getRoleId()) != 0){
            return AppResponse.bizError("角色编号已存在，请重新输入");
        }
        if (roleMapper.addRole(roleInfo) == 0){
            return AppResponse.bizError("用户角色新增失败");
        }
        return AppResponse.success("新增角色成功");
    }
    //修改角色信息
    @Override
    public AppResponse updateRole(RoleInfo roleInfo) {
        if (roleMapper.updateRole(roleInfo) == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    @Override
    public AppResponse deleteRole(List<String> roleId) {
        if (roleMapper.deleteRole(roleId) == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }

    @Override
    public AppResponse listRole(RoleInfo roleInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("roleInfo",roleInfo);
        Page<RoleInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() -> {
            roleMapper.listRole(param);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    @Override
    public AppResponse addRoleUser(List<String> userId, String roleId) {
        if (roleMapper.addRoleUser(userId,roleId) == 0){
            return AppResponse.bizError("添加失败");
        }
        return AppResponse.success("添加成功");
    }

    @Override
    public AppResponse deleteRoleUser(List<String> userId, String roleId) {
        if (roleMapper.deleteRoleUser(userId,roleId) == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }

    @Override
    public AppResponse getUsersByRole(RoleUserInfo roleUserInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("roleUserInfo",roleUserInfo);
        Page<RoleUserInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            roleMapper.getUsersByRole(param);
        });
        return AppResponse.success("查询成功",PagedData.getInstance(page));
    }
}
