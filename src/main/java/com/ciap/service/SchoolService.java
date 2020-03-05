package com.ciap.service;

import com.ciap.dao.SchoolRepository;
import com.ciap.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * 学院服务类
 * @version 1.0
 * @author ypq
 */

@Service
public class SchoolService {
    /**
     * School Dao接口
     */
    @Autowired
    private SchoolRepository schoolRepository;

    /**
     * 查询所有学院
     * @return 学院对象List
     */
    public List<School> searchAllSchools(){
        return schoolRepository.findAll();
    }

    /**
     * 按编号查询学院
     * @param a_id 学院编号
     * @return 包含学院对象的Optional对象 查询失败返回空Optional对象
     */
    public Optional<School> searchSchoolById(String a_id){
        if(a_id!=null)
            return schoolRepository.findById(a_id);
        return Optional.empty();
    }

    /**
     * 按编号查找学院是否存在
     * @param a_id 学员编号
     * @return 不存在或参数为null则返回false
     */
    public boolean existsById(String a_id){
        if(a_id!=null)
            return schoolRepository.existsById(a_id);
        return false;
    }
}
