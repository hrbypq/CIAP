package com.ciap.dao;

import com.ciap.entity.Curriculum;
import com.ciap.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 文件Dao接口
 * @version 1.0
 * @author ypq
 */

public interface MaterialRepository extends JpaRepository<Material,String> {
    List<Material> findByCurriculum(Curriculum curriculum);
}
