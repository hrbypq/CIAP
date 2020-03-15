package com.ciap.service;

import com.ciap.dao.CommentRepository;
import com.ciap.dao.CurriculumRepository;
import com.ciap.entity.Comment;
import com.ciap.entity.Curriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 评论服务类
 * @version 1.0
 * @author lhy
 */

@Service
public class CommentService {

    @Autowired
    /*
     * Comment Dao接口
     */
    private CommentRepository commentRepository;

    @Autowired
    /*
     *Curriculum Dao接口
     */
    private CurriculumRepository curriculumRepository;

    /**
     * 新添评论
     * @param a_comment 评论对象
     * @return 是否添加成功
     */
    public boolean createComment(Comment a_comment){
        if (a_comment==null)
            return false;
        commentRepository.save(a_comment);
        return true;
    }

    /**
     * 查询某课程下所有评论
     * @param a_curr_id 课程主键
     * @return 评论List
     */
    public List<Comment> printComment(String a_curr_id){
        List<Comment>res=new ArrayList<>();
        Optional<Curriculum> curriculum=curriculumRepository.findById(a_curr_id);
        if(curriculum.isEmpty())
            return res;
        else
            res=commentRepository.findAllByCurriculum(curriculum.get());
        return res;
    }

    /**
     * 删除评论
     * @param a_id 评论id
     * @return 是否删除成功
     */
    public boolean deleteComment(int a_id){
        if(!commentRepository.existsById(a_id))
            return false;
        commentRepository.deleteById(a_id);
        return !commentRepository.existsById(a_id);
    }

}
