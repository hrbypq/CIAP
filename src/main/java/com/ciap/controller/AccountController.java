package com.ciap.controller;

import com.ciap.dao.SchoolRepository;
import com.ciap.entity.School;
import com.ciap.entity.Student;
import com.ciap.entity.Teacher;
import com.ciap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

/**
 * 账户控制类
 * @version 1.0
 * @author lhy
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    /**
     * AccountService 服务类
     */
    @Autowired
    private AccountService accountService;

    @Autowired
    private SchoolRepository schoolRepository;

    /**
     * 新建学生对象
     * @param a_student 学生对象
     * @return 是否创建成功
     */
    @PostMapping("createStudentAccount")
    public boolean createStudentAccount(@RequestBody  Student a_student){
        if(a_student!=null){
            return accountService.createStudentAccount(a_student);
        }
        else
            return false;
    }

    /**
     * 新建教师对象
     * @param a_teacher 教师对象
     * @return 是否创建成功
     */
    @PostMapping("createTeacherAccount")
    public boolean createTeacherAccount(@RequestBody Teacher a_teacher){
        if(a_teacher==null) {
            return false;
        }
        String a_school_id=a_teacher.getSchool_id();
        if(!schoolRepository.existsById(a_school_id)) {
            return false;
        }
        Optional<School> school=schoolRepository.findById(a_school_id);
        if(school.isEmpty())
            return false;
        a_teacher.setSchool(school.get());
        return accountService.createTeacherAccount(a_teacher);
    }

    /**
     * 更新学生密码
     * @param a_id 学生id
     * @param a_pwd 新密码
     * @return 是否更新成功
     */
    @PutMapping("updateStudentPassword/{a_id}/{a_pwd}")
    public boolean updateStudentPassword(@PathVariable("a_id") String a_id,@PathVariable("a_pwd") String a_pwd){
        return accountService.updateStudentPassword(a_id,a_pwd);
    }

    /**
     * 更新教师密码
     * @param a_id 教师id
     * @param a_pwd 新密码
     * @return 是否更新成功
     */
    @PutMapping("updateTeacherPassword/{a_id}/{a_pwd}")
    public boolean updateTeacherPassword(@PathVariable("a_id") String a_id,@PathVariable("a_pwd") String a_pwd){
        return accountService.updateTeacherPassword(a_id,a_pwd);
    }

    /**
     * 更新教师简介
     * @param a_id 教师id
     * @param a_intro 新简介
     * @return 是否更新成功
     */
    @PutMapping("updateTeacherInfo/{a_id}/{a_intro}")
    public boolean updateTeacherInfo(@PathVariable("a_id") String a_id,@PathVariable("a_intro") String a_intro){
        return accountService.updateTeacherInfo(a_id,a_intro);
    }

    /**
     * 学生登录方法
     * @param a_id 学生id
     * @param a_pwd 密码
     * @return 是否登录成功
     */
    @GetMapping("signStudent/{a_id}/{a_pwd}")
    public boolean signStudent(@PathVariable("a_id") String a_id,@PathVariable("a_pwd") String a_pwd){
        return accountService.signStudent(a_id,a_pwd);
    }

    /**
     * 教师登陆方法
     * @param a_id 教师id
     * @param a_pwd 密码
     * @return 是否登录成功
     */
    @GetMapping("signTeacher/{a_id}/{a_pwd}")
    public boolean signTeacher(@PathVariable("a_id") String a_id,@PathVariable("a_pwd") String a_pwd) {
        return accountService.signTeacher(a_id, a_pwd);
    }

    /**
     * 查询教师用户方法
     * @param a_id 教师id
     * @return 教师对象
     */
    @GetMapping("searchTeacher/{a_id}")
    public Teacher searchTeacher(@PathVariable("a_id") String a_id){
        return accountService.searchTeacher(a_id);
    }

    /**
     * 查询学生用户
     * @param a_id 学生id
     * @return 学生对象
     */
    @GetMapping("searchStudent/{a_id}")
    public Student searchStudent(@PathVariable("a_id") String a_id){
        return accountService.searchStudent(a_id);
    }
}
