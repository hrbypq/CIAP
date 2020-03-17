package com.ciap.controller;

import com.ciap.entity.StudentCurr;
import com.ciap.service.StudentCurrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 学生-课程关系 控制类
 * @version 1.0
 * @author ypq
 */

@RestController
@RequestMapping("/student_curr")
public class StudentCurrController {

    @Autowired
    private StudentCurrService studentCurrService;

    /**
     * 查询某学生参加的课程的id
     * @param student_id 学生id
     * @return 课程id的List 查询失败返回空List
     */
    @GetMapping("/searchCurrIdByStudentId/{student_id}")
    public List<String> searchCurrIdByStudentId(@PathVariable("student_id") String student_id){
        return studentCurrService.searchCurrIdByStudentId(student_id);
    }

    /**
     * 查询参加某课程的学生的id
     * @param curr_id 课程id
     * @return 学生id的List 查询失败返回空List
     */
    @GetMapping("/searchStudentIdByCurrId/{curr_id}")
    public List<String> searchStudentIdByCurrId(@PathVariable("curr_id") String curr_id){
        return studentCurrService.searchStudentIdByCurrId(curr_id);
    }

    /**
     * 新增学生-课程关系
     * @param studentCurr 学生-课程关系对象
     * @return 是否新增成功
     */
    @PostMapping("/createParticipation")
    public boolean createParticipation(@RequestBody StudentCurr studentCurr){
        return studentCurrService.createParticipation(studentCurr);
    }

    /**
     * 删除学生-课程关系
     * @param student_id 学生id
     * @param curr_id 课程id
     * @return 是否删除成功
     */
    @DeleteMapping("deleteParticipation/{student_id}/{curr_id}")
    public boolean deleteParticipation(@PathVariable("student_id") String student_id,@PathVariable("curr_id") String curr_id){
        return studentCurrService.deleteParticipation(student_id,curr_id);
    }
}
