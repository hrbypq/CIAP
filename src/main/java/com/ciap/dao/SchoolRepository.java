package com.ciap.dao;

import com.ciap.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学院Dao接口
 * @version 1.0
 * @author ypq
 */

public interface SchoolRepository extends JpaRepository<School,String> {
}
