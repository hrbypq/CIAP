package com.ciap.service;

import com.ciap.dao.StudentRepository;
import com.ciap.dao.TeacherRepository;
import com.ciap.entity.Student;
import com.ciap.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * 账户服务类
 * @version 1.0
 * @author lhy
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
     * @param a_student 学生对象
     * @return 是否创建成功
     */
    public boolean createStudentAccount(Student a_student){
        if(a_student==null)
            return false;
        if(!studentRepository.existsById(a_student.getId())) {
            studentRepository.save(a_student);
            return true;
        }
        return false;
    }

    /**
     * 创建教师用户
     * @param a_teacher 教师对象
     * @return 是否创建成功
     */
    public boolean createTeacherAccount(Teacher a_teacher){
        if(a_teacher==null)
            return false;
        if(!teacherRepository.existsById(a_teacher.getId())) {
            teacherRepository.save(a_teacher);
            return true;
        }
        return false;
    }

    /**
     * 修改学生密码
     * @param a_id 学生id
     * @param a_pwd 新密码
     * @return 是否修改成功
     */
    public boolean updateStudentPassword(String a_id,String a_pwd){
        if(!studentRepository.existsById(a_id))
            return false;
        Optional<Student> s=studentRepository.findById(a_id);
        if(s.isEmpty())
            return false;
        Student student=s.get();
        student.setPassword(a_pwd);
        Student res=studentRepository.save(student);
        return a_pwd.equals(res.getPassword());
    }

    /**
     * 更改教师密码
     * @param a_id 教师id
     * @param a_pwd 新密码
     * @return 是否修改成功
     */
    public boolean updateTeacherPassword(String a_id,String a_pwd){
        if(!teacherRepository.existsById(a_id))
            return false;
        Optional<Teacher> t=teacherRepository.findById(a_id);
        if(t.isEmpty())
            return false;
        Teacher teacher=t.get();
        teacher.setPassword(a_pwd);
        Teacher res=teacherRepository.save(teacher);
        return a_pwd.equals(res.getPassword());
    }

    /**
     * 更新教师个人简介
     * @param a_id 教师id
     * @param a_intro 新简介
     * @return 成否修改成功
     */
    public boolean updateTeacherInfo(String a_id,String a_intro){
        if(!teacherRepository.existsById(a_id))
            return false;
        Optional<Teacher> t=teacherRepository.findById(a_id);
        if(t.isEmpty())
            return false;
        Teacher teacher=t.get();
        teacher.setIntro(a_intro);
        Teacher res=teacherRepository.save(teacher);
        return a_intro.equals(res.getIntro());

    }

    /**
     * 查询教师对象
     * @param a_id 教师id
     * @return 教师对象 查询失败返回null
     */
    public Teacher searchTeacher(String a_id){
        Optional<Teacher> teacher=teacherRepository.findById(a_id);
        return teacher.orElse(null);
    }

    /**
     * 查询学生对象
     * @param a_id 学生id
     * @return 学生对象 查询失败返回null
     */
    public Student searchStudent(String a_id){
        Optional<Student> student=studentRepository.findById(a_id);
        return student.orElse(null);
    }

    /**
     * 教师登录
     * @param a_id 教师id
     * @param a_pwd 密码
     * @return 是否验证成功
     */
    public boolean signTeacher(String a_id,String a_pwd){
        if(!teacherRepository.existsById(a_id))
            return false;
        Teacher teacher=searchTeacher(a_id);
        return a_pwd.equals(teacher.getPassword());
    }

    /**
     * 学生登录
     * @param a_id 学生id
     * @param a_pwd 密码
     * @return 是否验证成功
     */
    public boolean signStudent(String a_id,String a_pwd){
        if(!studentRepository.existsById(a_id))
            return false;
        Optional<Student> student=studentRepository.findById(a_id);
        if (student.isEmpty())
            return false;
        return a_pwd.equals(student.get().getPassword());
    }

    /**
     * 根据编号查询教师是否存在
     * @param a_teacher_id 教师编号
     * @return 若不存在或参数为null则返回false
     */
    public boolean teacherExistsById(String a_teacher_id){
        if(a_teacher_id!=null)
            return teacherRepository.existsById(a_teacher_id);
        return false;
    }
}
