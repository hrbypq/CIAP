package com.ciap.controller;

import com.ciap.dao.CurriculumRepository;
import com.ciap.entity.Comment;
import com.ciap.entity.Curriculum;
import com.ciap.service.CommentService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 评论控制类
 * @version 1.0
 * @author lhy
 */

@RestController
@RequestMapping("/comment")
public class CommentController {

    /**
     * Comment Service 服务类
     */
    @Autowired
    private CommentService commentService;

    @Autowired
    private CurriculumRepository curriculumRepository;

    /**
     * 新建评论
     * @param a_comment 评论对象
     * @return 是否创建成功的布尔值
     */
    @PostMapping("createComment")
    public boolean createComment(@RequestBody Comment a_comment){
        if(a_comment==null) {
            return false;
        }
        //初始化 Curriculum 属性
        String curriculum_id=a_comment.getCurriculum_id();
        if(!curriculumRepository.existsById(curriculum_id)) {
            return false;
        }
        Optional<Curriculum> curriculum=curriculumRepository.findById(curriculum_id);
        if(curriculum.isEmpty())
            return false;
        a_comment.setCurriculum(curriculum.get());
        //向数据库中存储comment对象
        return commentService.createComment(a_comment);
    }

    /**
     * 根据课程主键查询评论
     * @param a_curriculum_id 课程id
     * @return 返回包含指定课程属性的List容器，查询失败返回空容器
     */
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @GetMapping("printComment/{a_curriculum_id}")
    public List<Comment>printComment (@PathVariable("a_curriculum_id") String a_curriculum_id){
        return commentService.printComment(a_curriculum_id);
    }

    /**
     *删除评论
     * @param a_id 评论id
     * @return 是否删除成功的布尔值
     */
    @DeleteMapping("deleteComment/{a_id}")
    @Transactional
    public boolean deleteComment(@PathVariable("a_id") int a_id){
        return commentService.deleteComment(a_id);
    }
}
