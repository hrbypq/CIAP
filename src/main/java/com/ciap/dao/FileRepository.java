package com.ciap.dao;

import com.ciap.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 文件Dao接口
 * @version 1.0
 * @author ypq
 */

public interface FileRepository extends JpaRepository<File,String> {
}