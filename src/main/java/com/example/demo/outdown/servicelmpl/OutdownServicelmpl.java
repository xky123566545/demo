package com.example.demo.outdown.servicelmpl;

import com.example.demo.godown.entity.GodownInfo;
import com.example.demo.godown.mapper.GodownMapper;
import com.example.demo.godown.service.GodownService;
import com.example.demo.outdown.entity.OutdownInfo;
import com.example.demo.outdown.mapper.OutdownMapper;
import com.example.demo.outdown.service.OutdownService;
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
public class OutdownServicelmpl implements OutdownService {
    @Resource
    private OutdownMapper outdownMapper;
    /**
     * 新增入库单信息
     * @param outdownInfo
     * @return
     */
    @Override
    public AppResponse addOutdown(OutdownInfo outdownInfo) {
        //生成出库单编号
        outdownInfo.setOutdownId(UUID.randomUUID().toString().replace("-",""));
        String inventoryId = outdownInfo.getInventoryId();
        String cnt = outdownInfo.getOutdownCnt();
        Integer cntI = Integer.parseInt(cnt);
        //修改仓库库存
        if (outdownMapper.updateCnt(inventoryId,cntI) == 0){
            return AppResponse.bizError("修改仓库库存失败");
        }
        if (outdownMapper.addOutdown(outdownInfo) == 0){
            return AppResponse.bizError("新增失败");
        }
        return AppResponse.success("新增成功");
    }

    @Override
    public AppResponse listOutdown(OutdownInfo outdownInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("outdown",outdownInfo);
        Page<OutdownInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            outdownMapper.listOutdown(param);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    @Override
    public AppResponse updateOutdown(OutdownInfo outdownInfo) {
        if (outdownMapper.updateOutdown(outdownInfo) == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 修改入库单状态
     * @param outdownId
     * @param status
     * @return
     */
    @Override
    public AppResponse updateOutStatus(String outdownId, String status) {
        if (outdownMapper.updateOutStatus(outdownId,status) == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }
}
