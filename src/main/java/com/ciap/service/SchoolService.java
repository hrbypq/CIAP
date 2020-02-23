package com.ciap.service;

import com.ciap.dao.SchoolRepository;
import com.ciap.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
