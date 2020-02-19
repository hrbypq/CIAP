package com.ciap.dao;

import com.ciap.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * 课程Dao接口
 * @version 1.0
 * @author ypq
 */

public interface CurriculumRepository extends JpaRepository<Curriculum,String> {
    Set<Curriculum> findByName(String a_name);
    Set<Curriculum> findByTeacher(String a_teacher_name);
    Set<Curriculum> findBySchool(String a_school_name);
}
