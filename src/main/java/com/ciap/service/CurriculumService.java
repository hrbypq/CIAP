package com.ciap.service;

import com.ciap.dao.CurrInfoRepository;
import com.ciap.dao.CurriculumRepository;
import com.ciap.entity.CurrInfo;
import com.ciap.entity.Curriculum;
import com.ciap.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

/**
 * 课程服务类
 * @version 1.0
 * @author ypq
 */

@Service
public class CurriculumService {
    /**
     * Curriculum Dao接口
     */
    @Autowired
    private CurriculumRepository curriculumRepository;

    /**
     * CurrInfo Dao接口
     */
    @Autowired
    private CurrInfoRepository currInfoRepository;

    /**
     * 按课程名称搜索课程
     * @param a_name 课程名
     * @return 所需课程对象Set 查询失败返回空Set
     */
    public Set<Curriculum> searchByName(String a_name){
        Set<Curriculum>curriculumSet=curriculumRepository.findByName(a_name);
        return curriculumSet;
    }

    /**
     * 按教师姓名搜索课程
     * @param a_teacher_name 教师名
     * @return 所需课程对象Set 查询失败返回空Set
     */
    public Set<Curriculum> searchByTeacher(String a_teacher_name){
        Set<Curriculum>curriculumSet=curriculumRepository.findByTeacher(a_teacher_name);
        return curriculumSet;
    }

    /**
     * 按学院搜索课程
     * @param a_school_name 学院名
     * @return 所需课程对象Set 查询失败返回空Set
     */
    public Set<Curriculum> searchBySchool(String a_school_name){
        Set<Curriculum>curriculumSet=curriculumRepository.findBySchool(a_school_name);
        return curriculumSet;
    }

    /**
     * 新增课程
     * @param a_curriculum 课程对象
     * @return 是否添加成功
     */
    public boolean createCurriculum(Curriculum a_curriculum){
        if(curriculumRepository.save(a_curriculum)!=null)
            return true;
        return false;
    }

    /**
     * 更新课程
     * @param a_curriculum 更新后的的课程对象
     * @return 是否更新成功
     */
    public boolean updateCurriculum(Curriculum a_curriculum){
        if(a_curriculum!=null)
            curriculumRepository.deleteById(a_curriculum.getId());
        else
            return false;
        if(curriculumRepository.save(a_curriculum)!=null)
            return true;
        return false;
    }

    /**
     * 删除课程
     * @param a_curr_id 课程id
     */
    public void deleteCurriculum(String a_curr_id){
        curriculumRepository.deleteById(a_curr_id);
    }

    /**
     * 查询课程编号对应的课程信息
     * @param a_curr_id 课程编号
     * @return 对应的课程信息对象 查询失败返回空Optional对象
     */
    public Optional<CurrInfo> searchCurrInfo(String a_curr_id){
        Optional<CurrInfo> currInfo=currInfoRepository.findById(a_curr_id);
        return currInfo;
    }

    /**
     * 新建课程信息
     * @param a_currinfo 课程信息对象
     * @return 是否添加成功
     */
    public boolean createCurrInfo(CurrInfo a_currinfo){
        if(currInfoRepository.save(a_currinfo)!=null)
            return true;
        return false;
    }

    /**
     * 更新课程信息
     * @param a_currinfo 更新后的课程信息对象
     * @return 是否更新成功
     */
    public boolean updateCurrInfo(CurrInfo a_currinfo){
        if(a_currinfo!=null)
            currInfoRepository.deleteById(a_currinfo.getId());
        else
            return false;
        if(currInfoRepository.save(a_currinfo)!=null)
            return true;
        return false;
    }

    /**
     * 删除课程信息
     * @param a_curr_id
     */
    public void deleteCurrInfo(String a_curr_id){
        currInfoRepository.deleteById(a_curr_id);
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
