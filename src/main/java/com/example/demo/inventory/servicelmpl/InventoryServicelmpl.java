package com.example.demo.inventory.servicelmpl;

import com.example.demo.inventory.entity.InventoryInfo;
import com.example.demo.inventory.mapper.InventoryMapper;
import com.example.demo.inventory.service.InventoryService;
import com.example.demo.util.AppResponse;
import com.example.demo.util.PagedData;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class InventoryServicelmpl implements InventoryService {
    @Resource
    private InventoryMapper inventoryMapper;

    /**
     * 新增库存信息
     * @param inventoryInfo
     * @return
     */
    @Override
    public AppResponse saveInventory(InventoryInfo inventoryInfo) {
        //查看库存名称是否存在
        String inventoryCount = inventoryInfo.getInventoryCount();
        Integer inventoryCountI = Integer.parseInt(inventoryCount);
        String inventoryName = inventoryInfo.getInventoryName();
        if (inventoryMapper.countInventoryName(inventoryName) != 0){
            //将库存叠加
            if (inventoryMapper.addInventoryCount(inventoryName,inventoryCountI) == 0){
                return AppResponse.bizError("叠加库存失败");
            }
        }
        else {
            //生成库存编号
            inventoryInfo.setInventoryId(UUID.randomUUID().toString().replace("-", ""));
            if (inventoryMapper.saveInventory(inventoryInfo) == 0) {
                return AppResponse.bizError("新增失败");
            }
        }
        return AppResponse.success("新增成功");
    }

    @Override
    public AppResponse listInventory(InventoryInfo inventoryInfo, Integer pageNo, Integer pageSize) {
        Map<String,Object> param = new HashMap<>();
        param.put("inventory",inventoryInfo);
        Page<InventoryInfo> page = PageHelper.startPage(pageNo,pageSize).doSelectPage(() ->{
            inventoryMapper.listInventory(param);
        });
        return AppResponse.success("查询成功", PagedData.getInstance(page));
    }

    @Override
    public AppResponse updateInventory(InventoryInfo inventoryInfo) {
        if (inventoryMapper.updateInventory(inventoryInfo) == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    @Override
    public AppResponse deleteInventory(List<String> inventoryId) {
        if(inventoryMapper.deleteInventory(inventoryId) == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
