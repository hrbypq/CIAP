package com.ciap.service;

import com.ciap.dao.*;
import com.ciap.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
     * School Dao接口
     */
    @Autowired
    private SchoolRepository schoolRepository;

    /**
     * Material Dao接口
     */
    @Autowired
    private MaterialRepository materialRepository;

    /**
     * Comment Dao接口
     */
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 按课程名称搜索课程 可模糊查询
     * @param a_name 课程名
     * @return 对应的课程对象List 查询失败或参数为null则返回空List
     */
    public List<Curriculum> searchByName(String a_name){
        if(a_name==null)
            return new ArrayList<>();
        return curriculumRepository.findByNameLike("%"+a_name+"%");
    }

    /**
     * 按教师姓名搜索课程
     * @param a_teacher_name 教师名
     * @return 对应的课程对象List 查询失败或参数为null则返回空List
     */
    public List<Curriculum> searchByTeacherName(String a_teacher_name){
        if(a_teacher_name==null)
            return new ArrayList<>();
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
     * 按学院编号搜索课程
     * @param a_school_id 学院编号
     * @return 对应的课程对象List 查询失败或参数为null则返回空List
     */
    public List<Curriculum> searchBySchoolId(String a_school_id){
        if(a_school_id==null)
            return new ArrayList<>();
        //按学院编号查询学院对象
        Optional<School> school=schoolRepository.findById(a_school_id);
        if(!school.isPresent())
            return new ArrayList<>();
        return curriculumRepository.findBySchool(school.get());
    }

    /**
     * 新增课程
     * @param a_curriculum 课程对象
     * @return 参数对象为空或对象已存在则返回false
     */
    public boolean createCurriculum(Curriculum a_curriculum){
        if(a_curriculum!=null){
            if(curriculumRepository.existsById(a_curriculum.getId()))
                return false;
            curriculumRepository.save(a_curriculum);
            return true;
        }
        return false;
    }

    /**
     * 更新课程 停用
     * @param a_curriculum 更新后的的课程对象
     * @return 若参数对象为空或课程编号不存在则返回false
     */
    public boolean updateCurriculum(Curriculum a_curriculum){
        if(a_curriculum!=null&&curriculumRepository.existsById(a_curriculum.getId())){
            this.deleteCurriculum(a_curriculum.getId());
            this.createCurriculum(a_curriculum);
            return true;
        }
        return false;
    }

    /**
     * 删除课程
     * @param a_curr_id 课程id
     * @return 若课程编号不存在或参数为null则返回false
     */
    @Transactional
    public boolean deleteCurriculum(String a_curr_id){
        if(a_curr_id!=null&&curriculumRepository.existsById(a_curr_id)){
            //删除课程下所有评论
            commentRepository.deleteAllByCurriculum(curriculumRepository.findById(a_curr_id).get());
            //删除课程下所有资料
            materialRepository.deleteAllByCurriculum(curriculumRepository.findById(a_curr_id).get());
            curriculumRepository.deleteById(a_curr_id);
            return true;
        }
        return false;
    }

    /**
     * 查询课程编号对应的课程信息
     * @param a_curr_id 课程编号
     * @return 对应的课程信息对象 查询失败或参数为null则返回空Optional对象
     */
    public Optional<CurrInfo> searchCurrInfoById(String a_curr_id){
        if(a_curr_id==null)
            return Optional.empty();
        return currInfoRepository.findById(a_curr_id);
    }

    /**
     * 新建课程信息
     * @param a_currinfo 课程信息对象
     * @return 参数对象为空或对象已存在则返回false
     */
    public boolean createCurrInfo(CurrInfo a_currinfo){
        if(a_currinfo!=null){
            if(currInfoRepository.existsById(a_currinfo.getId()))
                return false;
            currInfoRepository.save(a_currinfo);
            return true;
        }
        return false;
    }

    /**
     * 更新课程信息 停用
     * @param a_currinfo 更新后的课程信息对象
     * @return 若参数对象为空或课程编号不存在则返回false
     */
    public boolean updateCurrInfo(CurrInfo a_currinfo){
        if(a_currinfo!=null&&currInfoRepository.existsById(a_currinfo.getId())){
            this.deleteCurrInfo(a_currinfo.getId());
            this.createCurrInfo(a_currinfo);
            return true;
        }
        return false;
    }

    /**
     * 删除课程信息
     * @param a_curr_id 课程编号
     * @return 若课程编号不存在或参数为null则返回false
     */
    public boolean deleteCurrInfo(String a_curr_id){
        if(a_curr_id!=null&&currInfoRepository.existsById(a_curr_id)){
            currInfoRepository.deleteById(a_curr_id);
            return true;
        }
        return false;
    }
}
