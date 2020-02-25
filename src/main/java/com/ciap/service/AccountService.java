package com.ciap.service;

import com.ciap.dao.CurriculumRepository;
import com.ciap.dao.StudentRepository;
import com.ciap.dao.TeacherRepository;
import com.ciap.entity.Student;
import com.ciap.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户服务类
 * @version 1.0
 * @author
 */

@Service
public class AccountService {

    /**
      Student Dao接口
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
      Teacher Dao接口
     */
    @Autowired
    private TeacherRepository teacherRepository;
    /**
     * 创建学生用户
     * @param a_student
     * @return
     */
    public boolean createStudentAccount(Student a_student){
        if(a_student==null)
            return false;
        if(!studentRepository.existsById(a_student.getId())) {
            Student res = null;
            res = studentRepository.save(a_student);
            return true;
        }
        else
            return false;
    }

    /**
     *
     * @param a_teacher
     * @return
     */
    public boolean createTeacherAccount(Teacher a_teacher){
        if(a_teacher==null)
            return false;
        if(!teacherRepository.existsById(a_teacher.getId())) {
            Teacher res = null;
            res = teacherRepository.save(a_teacher);
            return true;
        }
        else
            return false;

    }

    /**
     *
     * @param a_id
     * @param a_pwd
     * @return
     */
    public boolean updateStudentPassword(String a_id,String a_pwd){
        Student student=studentRepository.findById(a_id).get();
        student.setPassword(a_pwd);
        Student res=studentRepository.save(student);
        if(a_pwd.equals(res.getPassword()))
            return true;
        else
            return false;
    }

    /**
     *
     * @param a_id
     * @param a_pwd
     * @return
     */
    public boolean updateTeacherPassword(String a_id,String a_pwd){
        Teacher teacher=teacherRepository.findById(a_id).get();
        teacher.setPassword(a_pwd);
        Teacher res=teacherRepository.save(teacher);
        if(a_pwd.equals(res.getPassword()))
            return true;
        else
            return false;
    }

    /**
     *
     * @param a_id
     * @param a_intro
     * @return
     */
    public boolean updateTeacherInfo(String a_id,String a_intro){
        Teacher teacher=teacherRepository.findById(a_id).get();
        teacher.setIntro(a_intro);
        Teacher res=teacherRepository.save(teacher);
        if(a_intro.equals(res.getIntro()))
            return true;
        else
            return false;

    }
    /**
     * @param  a_id
     * @return
     */
    public Teacher searchTeacher(String a_id){
     Teacher teacher=null;
     teacher=teacherRepository.findById(a_id).get();
     return  teacher;
    }
    /**
     * @param a_id
     * @param a_pwd
     * @return
     */
    public boolean signTeacher(String a_id,String a_pwd){
        if(!teacherRepository.existsById(a_id))
            return false;
        Teacher teacher=searchTeacher(a_id);
        return a_pwd.equals(teacher.getPassword());
    }
    /**
     * @param a_id
     * @param a_pwd
     * @return
     */
    public boolean signStudent(String a_id,String a_pwd){
        if(!studentRepository.existsById(a_id))
            return false;
        Student student=studentRepository.findById(a_id).get();
        return a_pwd.equals(student.getPassword());
    }
}
