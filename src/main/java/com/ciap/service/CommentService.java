package com.ciap.service;

import com.ciap.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 评论服务类
 * @version 1.0
 * @author
 */

@Service
public class CommentService {
    /**
     *
     * @param a_comment
     * @return
     */
    public boolean createComment(Comment a_comment){
        return true;
    }

    /**
     *
     * @param a_curr_id 课程主键
     * @return
     */
    public Set<Comment>printComment(String a_curr_id){
        return null;
    }

    /**
     *
     * @param a_id
     * @return
     */
    public boolean deleteComment(String a_id){
        return true;
    }
}
