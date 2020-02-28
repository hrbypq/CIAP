package com.ciap.service;

import com.ciap.dao.CommentRepository;
import com.ciap.dao.CurriculumRepository;
import com.ciap.entity.Comment;
import com.ciap.entity.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (a_comment==null)
            return false;
        Comment comment=commentRepository.save(a_comment);
        return true;
    }

    /**
     *
     * @param a_curr_id 课程主键
     * @return
     */

    public List<Comment> printComment(String a_curr_id){
        List<Comment>res=new ArrayList<Comment>();
        Optional<Curriculum> curriculum=curriculumRepository.findById(a_curr_id);
        if(!curriculum.isPresent())
            return res;
        else
            res=commentRepository.findAllByCurriculum(curriculum.get());
        return res;
    }

    /**
     *
     * @param a_id
     * @return
     */
    public boolean deleteComment(int a_id){
        if(!commentRepository.existsById(a_id))
            return false;
        commentRepository.deleteById(a_id);

        if(!commentRepository.existsById(a_id))
            return true;
        else
            return false;
    }
}
