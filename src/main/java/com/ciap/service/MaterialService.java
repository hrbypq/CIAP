package com.ciap.service;

import com.ciap.dao.CurriculumRepository;
import com.ciap.dao.MaterialRepository;
import com.ciap.entity.Curriculum;
import com.ciap.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文件服务类
 * @version 1.0
 * @author ypq
 */

@Service
public class MaterialService {
    /**
     * Material Dao接口
     */
    @Autowired
    private MaterialRepository materialRepository;

    /**
     * Curriculum Dao接口
     */
    @Autowired
    private CurriculumRepository curriculumRepository;

    /**
     * 新增文件记录
     * @param a_material 文件对象
     * @return 若参数对象为空或对象已存在则返回false
     */
    public boolean createMaterial(Material a_material){
        if(a_material!=null){
            if(materialRepository.existsById(a_material.getId()))
                return false;
            materialRepository.save(a_material);
            return true;
        }
        return false;
    }

    /**
     * 查询该课程的所有文件记录
     * @param a_curr_id 课程编号
     * @return 对应的文件对象List 查询失败或参数为null返回空List
     */
    public List<Material> searchByCurrId(String a_curr_id){
        if(a_curr_id==null)
            return new ArrayList<>();
        Optional<Curriculum>curriculum=curriculumRepository.findById(a_curr_id);
        if(!curriculum.isPresent())
            return new ArrayList<>();
        return materialRepository.findByCurriculum(curriculum.get());
    }

    /**
     * 删除文件记录
     * @param a_material_id 文件编号
     * @return 若文件编号不存在则返回false
     */
    public boolean deleteMaterial(int a_material_id){
        if(materialRepository.existsById(a_material_id)){
            materialRepository.deleteById(a_material_id);
            return true;
        }
        return false;
    }
}
