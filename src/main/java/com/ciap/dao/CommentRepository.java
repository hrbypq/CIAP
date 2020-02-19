package com.ciap.dao;

import com.ciap.entity.Comment;
import com.ciap.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


/**
 * 评论Dao接口
 * @version 1.0
 * @author ypq
 */

public interface CommentRepository extends JpaRepository<Comment,String> {
    Set<Comment> findAllByCurriculum(Curriculum curriculum);
    Comment findById(int a_id);
    void deleteById(int a_id);
    boolean existsById(int a_id);
}