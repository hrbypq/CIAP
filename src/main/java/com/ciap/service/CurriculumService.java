package com.ciap.service;

import com.ciap.dao.CurriculumRepository;
import com.ciap.entity.Curriculum;
import com.ciap.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 课程服务类
 * @version 1.0
 * @author
 */

@Service
public class CurriculumService {
    /**
     * Curriculum Dao接口
     */
    @Autowired
    private CurriculumRepository curriculumRepository;

    /**
     * 按名称搜索课程
     * @param a_name 课程名
     * @return 所需课程对象 查询失败返回null
     */
    public Curriculum searchByName(String a_name){
        Curriculum curriculum=curriculumRepository.findByName(a_name);
        return curriculum;
    }

    /**
     *
     * @param a_teacher_name
     * @return
     */
    public Curriculum searchByTeacher(String a_teacher_name){
        return null;
    }

    /**
     *
     * @param a_school_name
     * @return
     */
    public Curriculum searchBySchool(String a_school_name){
        return null;
    }

    /**
     *
     * @param a_curriculum
     * @return
     */
    public boolean createCurriculum(Curriculum a_curriculum){
        return false;
    }

    /**
     *
     * @param a_id
     * @return
     */
    public boolean deleteCurriculum(String a_id){
        return false;
    }

    /**
     *
     * @param a_curriculum
     * @return
     */
    public boolean updateCurriculum(Curriculum a_curriculum){
        return false;
    }

    public File downloadFile(){
        return null;
    }

    public boolean uploadFile(File a_file){
        return false;
    }

    public File searchFileByName(String a_file_name){
        return null;
    }
}
