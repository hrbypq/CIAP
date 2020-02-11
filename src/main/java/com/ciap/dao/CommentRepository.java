package com.ciap.dao;

import com.ciap.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 评论Dao接口
 * @version 1.0
 * @author ypq
 */

public interface CommentRepository extends JpaRepository<Comment,String> {
}
