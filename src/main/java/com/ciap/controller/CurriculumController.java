package com.ciap.controller;

import com.ciap.entity.Curriculum;
import com.ciap.service.CurriculumService;
import com.ciap.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 课程控制类
 * @version 1.0
 * @author ypq
 */

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    /**
     * CurriculumService 服务类
     */
    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private SchoolService schoolService;

    /**
     * 按课程名查询课程 可模糊查询
     * @param a_name 课程名
     * @return 课程对象List 查询失败则返回空List
     */
    @GetMapping("/searchCurrByName/{a_name}")
    public List<Curriculum> searchCurrByName(@PathVariable("a_name") String a_name){
        return curriculumService.searchByName(a_name);
    }

    /**
     * 按教师名查询课程
     * @param a_teacher_name 教师名
     * @return 课程对象List 查询失败则返回空List
     */
    @GetMapping("/searchCurrByTeacherName/{a_teacher_name}")
    public List<Curriculum> searchCurrByTeacherName(@PathVariable("a_teacher_name") String a_teacher_name){
        return curriculumService.searchByTeacherName(a_teacher_name);
    }

    /**
     * 按学院编号查询课程
     * @param a_school_id 学院编号
     * @return 课程对象List 查询失败则返回空List
     */
    @GetMapping("searchCurrBySchoolId/{a_school_id}")
    public List<Curriculum> searchCurrBySchoolId(@PathVariable("a_school_id") String a_school_id){
        return curriculumService.searchBySchoolId(a_school_id);
    }

    /**
     * 新建课程
     * @param a_curriculum 课程对象
     * @return 是否创建成功
     */
    @PostMapping("createCurriculum")
    public boolean createCurriculum(Curriculum a_curriculum){
        if(a_curriculum!=null){
            a_curriculum.setSchool(null);
        }
        return false;
    }
}
