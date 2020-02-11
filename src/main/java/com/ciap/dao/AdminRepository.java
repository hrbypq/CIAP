package com.ciap.dao;

import com.ciap.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 管理员Dao接口
 * @version 1.0
 * @author ypq
 */

public interface AdminRepository extends JpaRepository<Admin,String> {
}
