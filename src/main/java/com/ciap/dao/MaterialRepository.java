package com.ciap.dao;

import com.ciap.entity.Curriculum;
import com.ciap.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * 文件Dao接口
 * @version 1.0
 * @author ypq
 */

public interface MaterialRepository extends JpaRepository<Material,String> {
    Optional<Material> findById(int id);
    List<Material> findByCurriculum(Curriculum curriculum);
    boolean existsById(int id);
    void deleteById(int id);
    void deleteAllByCurriculum(Curriculum a_curriculum);
}
