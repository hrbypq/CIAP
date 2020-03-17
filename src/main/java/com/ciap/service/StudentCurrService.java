package com.ciap.service;

import com.ciap.dao.CurriculumRepository;
import com.ciap.dao.StudentCurrRepository;
import com.ciap.dao.StudentRepository;
import com.ciap.entity.StudentCurr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 学生-课程关系 服务类
 * @version 1.0
 * @author ypq
 */

@Service
public class StudentCurrService {

    @Autowired
    private StudentCurrRepository studentCurrRepository;

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 查询某学生参加的课程的id
     * @param student_id 学生id
     * @return 课程id的List 查询失败返回空List
     */
    public List<String> searchCurrIdByStudentId(String student_id){
        if(student_id==null)
            return new ArrayList<>();
        return studentCurrRepository.findCurrIdByStudentId(student_id);
    }

    /**
     * 查询参加某课程的学生的id
     * @param curr_id 课程id
     * @return 学生id的List 查询失败返回空List
     */
    public List<String> searchStudentIdByCurrId(String curr_id) {
        if(curr_id==null)
            return new ArrayList<>();
        return studentCurrRepository.findStudentIdByCurrId(curr_id);
    }

    /**
     * 新增学生-课程关系
     * @param studentCurr 学生-课程关系对象
     * @return 是否新增成功
     */
    public boolean createParticipation(StudentCurr studentCurr){
        if(studentCurr==null)
            return false;
        if(curriculumRepository.existsById(studentCurr.getCurrId())&&studentRepository.existsById(studentCurr.getStudentId())){
            studentCurrRepository.save(studentCurr);
            return true;
        }
        return false;
    }

    /**
     * 删除学生-课程关系
     * @param student_id 学生id
     * @param curr_id 课程id
     * @return 是否删除成功
     */
    public boolean deleteParticipation(String student_id,String curr_id){
        if(student_id==null||curr_id==null)
            return false;
        Optional<StudentCurr> studentCurr=studentCurrRepository.findByStudentIdAndCurrId(student_id,curr_id);
        if(studentCurr.isEmpty())
            return false;
        studentCurrRepository.deleteById(studentCurr.get().getId());
        return true;
    }
}
