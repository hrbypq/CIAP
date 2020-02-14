package com.ciap.service;

import com.ciap.entity.Student;
import com.ciap.entity.Teacher;
import org.springframework.stereotype.Service;

/**
 * 账户服务类
 * @version 1.0
 * @author
 */

@Service
public class AccountService {
    /**
     * 创建学生用户
     * @param a_student
     * @return
     */
    public boolean createStudentAccount(Student a_student){
        return true;
    }

    /**
     *
     * @param a_teacher
     * @return
     */
    public boolean createTeacherAccount(Teacher a_teacher){
        return true;
    }

    /**
     *
     * @param a_id
     * @return
     */
    public boolean updateStudentPassword(String a_id){
        return true;
    }

    /**
     *
     * @param a_id
     * @return
     */
    public boolean updateTeacherPassword(String a_id){
        return true;
    }

    /**
     *
     * @param a_id
     * @param a_intro
     * @return
     */
    public boolean updateTeacherInfo(String a_id,String a_intro){
        return true;
    }
}
