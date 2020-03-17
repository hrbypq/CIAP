package com.ciap.dao;

import com.ciap.entity.StudentCurr;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * 学生-课程关系 Dao接口
 * @version 1.0
 * @author ypq
 */

public interface StudentCurrRepository extends JpaRepository<StudentCurr,Integer> {
    List<String> findCurrIdByStudentId(String student_id);
    List<String> findStudentIdByCurrId(String curr_id);
    Optional<StudentCurr> findByStudentIdAndCurrId(String student_id,String curr_id);
}
