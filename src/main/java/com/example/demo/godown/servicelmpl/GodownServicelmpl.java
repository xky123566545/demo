package com.example.demo.godown.servicelmpl;

import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.godown.mapper.GodownMapper;
import com.example.demo.godown.service.GodownService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GodownServicelmpl implements GodownService {
    @Resource
    private GodownMapper godownMapper;
    /**
     * 新增入库单信息
     * @param godownInfo
     * @return
     */
    @Override
    public AppResponse addGodown(GodownInfo godownInfo) {
        //生成入库单编号
        godownInfo.setGodownId(UUID.randomUUID().toString().replace("-",""));
        if (godownMapper.addGodown(godownInfo) == 0){
            return AppResponse.bizError("新增失败");
        }
        return AppResponse.success("新增成功");
    }

    @Override
    public AppResponse listGodown(GodownInfo godownInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("godown",godownInfo);
        Page<GodownInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            godownMapper.listGodown(param);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    @Override
    public AppResponse updateGodown(GodownInfo godownInfo) {
        if (godownMapper.updateGodown(godownInfo) == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 修改入库单状态
     * @param godownId
     * @param status
     * @return
     */
    @Override
    public AppResponse updateStatus(String godownId, String status) {
        if (godownMapper.updateStatus(godownId,status) == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }
}
