package com.ciap.service;

import com.ciap.dao.CommentRepository;
import com.ciap.dao.CurriculumRepository;
import com.ciap.entity.Comment;
import com.ciap.entity.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CommentService {
    @Autowired
    /**
     * Comment Dao接口
     */
    private CommentRepository commentRepository;
    @Autowired
    /**
     *Curriculum dao接口
     */
    private CurriculumRepository curriculumRepository;
    /**
     *
     * @param a_comment
     * @return
     */
    public boolean createComment(Comment a_comment){
        Comment comment=commentRepository.save(a_comment);
        if(comment.equals(a_comment))
            return true;
        else
            return false;
    }

    /**
     *
     * @param a_curr_id 课程主键
     * @return
     */
    public Set<Comment> printComment(String a_curr_id){
        Set<Comment>res=null;
        Curriculum curriculum=curriculumRepository.getOne(a_curr_id);
        res=commentRepository.findAllByCurriculum(curriculum);
        return res;
    }

    /**
     *
     * @param a_id
     * @return
     */
    public boolean deleteComment(int a_id){
        commentRepository.deleteById(a_id);

        if(!commentRepository.existsById(a_id))
            return true;
        else
            return false;
    }
}
