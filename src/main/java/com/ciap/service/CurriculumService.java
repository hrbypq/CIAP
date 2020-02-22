package com.ciap.service;

import com.ciap.dao.CurrInfoRepository;
import com.ciap.dao.CurriculumRepository;
import com.ciap.dao.TeacherRepository;
import com.ciap.entity.CurrInfo;
import com.ciap.entity.Curriculum;
import com.ciap.entity.Material;
import com.ciap.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     * Teacher Dao接口
     */
    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * 按课程名称搜索课程
     * @param a_name 课程名
     * @return 所需课程对象List 查询失败返回空List
     */
    public List<Curriculum> searchByName(String a_name){
        List<Curriculum>curriculumList=curriculumRepository.findByName(a_name);
        return curriculumList;
    }

    /**
     * 按教师姓名搜索课程
     * @param a_teacher_name 教师名
     * @return 所需课程对象List 查询失败返回空List
     */
    public List<Curriculum> searchByTeacher(String a_teacher_name){
        //可能会有同名教师 用List存储
        List<Teacher>teacherList=teacherRepository.findByName(a_teacher_name);
        //最终得到的课程列表
        List<Curriculum>curriculumList=new ArrayList<>();
        //遍历同名教师列表
        for(Teacher teacher:teacherList){
            //该教师的课程列表
            List<Curriculum>curriculumList1=curriculumRepository.findByTeacher(teacher);
            for(Curriculum curriculum:curriculumList1)
                curriculumList.add(curriculum);
        }
        return curriculumList;
    }

    /**
     * 按学院搜索课程
     * @param a_school_name 学院名
     * @return 所需课程对象List 查询失败返回空List
     */
    public List<Curriculum> searchBySchool(String a_school_name){
        List<Curriculum>curriculumList=curriculumRepository.findBySchool(null);
        return curriculumList;
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
            this.deleteCurriculum(a_curriculum.getId());
        else
            return false;
        curriculumRepository.save(a_curriculum);
        return true;
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
            this.deleteCurrInfo(a_currinfo.getId());
        else
            return false;
        currInfoRepository.save(a_currinfo);
        return true;
    }

    /**
     * 删除课程信息
     * @param a_curr_id 课程编号
     */
    public void deleteCurrInfo(String a_curr_id){
        currInfoRepository.deleteById(a_curr_id);
    }

    /**
     *
     * @param a_material
     * @return
     */
    public boolean createMaterial(Material a_material){
        return false;
    }

    public Material searchMaterialByName(String a_file_name){
        return null;
    }
}
