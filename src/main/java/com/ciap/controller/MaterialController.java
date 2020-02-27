package com.ciap.controller;

import com.ciap.entity.Material;
import com.ciap.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 文件控制类
 * @version 1.0
 * @author ypq
 */

@RestController
@RequestMapping("/material")
public class MaterialController {
    /**
     * Material服务类
     */
    @Autowired
    private MaterialService materialService;

    @GetMapping("/searchMaterialByCurrId/{a_curr_id}")
    public List<Material> searchMaterialByCurrId(@PathVariable("a_curr_id") String a_curr_id){
        return materialService.searchByCurrId(a_curr_id);
    }
}
