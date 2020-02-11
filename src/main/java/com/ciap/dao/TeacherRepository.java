package com.ciap.dao;

import com.ciap.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 教师Dao接口
 * @version 1.0
 * @author ypq
 */

public interface TeacherRepository extends JpaRepository<Teacher,String> {
}
