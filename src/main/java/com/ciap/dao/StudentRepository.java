package com.ciap.dao;

import com.ciap.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学生Dao接口
 * @version 1.0
 * @author ypq
 */

public interface StudentRepository extends JpaRepository<Student,String> {
}
