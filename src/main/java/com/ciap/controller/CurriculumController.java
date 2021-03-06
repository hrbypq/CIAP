package com.ciap.controller;

import com.ciap.entity.CurrInfo;
import com.ciap.entity.Curriculum;
import com.ciap.entity.School;
import com.ciap.service.AccountService;
import com.ciap.service.CurriculumService;
import com.ciap.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * 课程控制类
 * @version 1.0
 * @author ypq
 */

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    /**
     * Curriculum服务类
     */
    @Autowired
    private CurriculumService curriculumService;

    /**
     * School服务类
     */
    @Autowired
    private SchoolService schoolService;

    /**
     * Account服务类
     */
    @Autowired
    private AccountService accountService;

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
    @GetMapping("/searchCurrBySchoolId/{a_school_id}")
    public List<Curriculum> searchCurrBySchoolId(@PathVariable("a_school_id") String a_school_id){
        return curriculumService.searchBySchoolId(a_school_id);
    }

    /**
     * 根据课程编号查询课程对象
     * @param id 课程编号
     * @return 课程对象 查询失败返回null
     */
    @GetMapping("searchCurrById/{id}")
    public Curriculum searchCurrById(@PathVariable("id") String id){
        return curriculumService.searchCurriculumById(id).orElse(null);
    }

    /**
     * 新建课程
     * @param a_curriculum 课程对象
     * @return 是否创建成功
     */
    @PostMapping("/createCurriculum")
    public boolean createCurriculum(@RequestBody Curriculum a_curriculum){
        if(a_curriculum!=null){
            if(schoolService.existsById(a_curriculum.getSchool_id())&&accountService.teacherExistsById(a_curriculum.getTeacher_id())){
                Optional<School> school=schoolService.searchSchoolById(a_curriculum.getSchool_id());
                if(school.isEmpty())
                    return false;
                a_curriculum.setSchool(school.get());
                a_curriculum.setTeacher(accountService.searchTeacher(a_curriculum.getTeacher_id()));
                return curriculumService.createCurriculum(a_curriculum);
            }
        }
        return false;
    }

    /**
     * 更新课程
     * @param a_curriculum 更新后的的课程对象
     * @return 是否更新成功
     */
    @PutMapping("/updateCurriculum")
    public boolean updateCurriculum(@RequestBody Curriculum a_curriculum){
        if(a_curriculum!=null){
            this.deleteCurriculumById(a_curriculum.getId());
            return this.createCurriculum(a_curriculum);
        }
        return false;
    }

    /**
     * 删除课程
     * @param a_curr_id 课程id
     * @return 若课程不存在返回false
     */
    @DeleteMapping("/deleteCurriculumById/{a_curr_id}")
    public boolean deleteCurriculumById(@PathVariable("a_curr_id") String a_curr_id){
        return curriculumService.deleteCurriculum(a_curr_id);
    }

    /**
     * 查询课程编号对应的课程信息
     * @param a_curr_id 课程编号
     * @return 对应的课程信息对象 查询失败返回null
     */
    @GetMapping("/searchCurrInfoById/{a_curr_id}")
    public CurrInfo searchCurrInfoById(@PathVariable("a_curr_id") String a_curr_id){
        Optional<CurrInfo> currInfo=curriculumService.searchCurrInfoById(a_curr_id);
        return currInfo.orElse(null);
    }

    /**
     * 新建课程信息
     * @param a_currinfo 课程信息对象
     * @return 是否新建成功
     */
    @PostMapping("/createCurrInfo")
    public boolean createCurrInfo(@RequestBody CurrInfo a_currinfo){
        return curriculumService.createCurrInfo(a_currinfo);
    }

    /**
     * 更新课程信息
     * @param a_currinfo 更新后的课程信息对象
     * @return 是否更新成功
     */
    @PutMapping("/updateCurrInfo")
    public boolean updateCurrInfo(@RequestBody CurrInfo a_currinfo){
        if(a_currinfo!=null){
            this.deleteCurrInfoById(a_currinfo.getId());
            return this.createCurrInfo(a_currinfo);
        }
        return false;
    }

    /**
     * 删除课程信息
     * @param a_curr_id 课程编号
     * @return 是否删除成功
     */
    @DeleteMapping("/deleteCurrInfoById/{a_curr_id}")
    public boolean deleteCurrInfoById(@PathVariable("a_curr_id") String a_curr_id){
        return curriculumService.deleteCurrInfo(a_curr_id);
    }
}
