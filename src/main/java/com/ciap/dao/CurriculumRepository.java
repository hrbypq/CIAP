package com.ciap.dao;

import com.ciap.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 课程Dao接口
 * @version 1.0
 * @author ypq
 */

public interface CurriculumRepository extends JpaRepository<Curriculum,String> {
}
