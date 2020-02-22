package com.ciap.dao;

import com.ciap.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 教师Dao接口
 * @version 1.0
 * @author ypq
 */

public interface TeacherRepository extends JpaRepository<Teacher,String> {
    List<Teacher>findByName(String a_name);
}
