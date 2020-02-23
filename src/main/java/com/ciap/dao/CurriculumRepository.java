package com.ciap.dao;

import com.ciap.entity.Curriculum;
import com.ciap.entity.School;
import com.ciap.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 课程Dao接口
 * @version 1.0
 * @author ypq
 */

public interface CurriculumRepository extends JpaRepository<Curriculum,String> {
    List<Curriculum> findByNameLike(String a_name);
    List<Curriculum> findByTeacher(Teacher a_teacher);
    List<Curriculum> findBySchool(School a_school);
}
