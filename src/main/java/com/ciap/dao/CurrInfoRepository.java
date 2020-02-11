package com.ciap.dao;

import com.ciap.entity.CurrInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 课程信息Dao接口
 * @version 1.0
 * @author ypq
 */

public interface CurrInfoRepository extends JpaRepository<CurrInfo,String> {
}
