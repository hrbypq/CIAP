package com.ciap.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_comment")
public class Comment {
    /**
     * 评论编号 主键 自动生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 所属课程编号 外键指向课程表主键 字段名称curriculum_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "curriculum_id",nullable = false)
    private Curriculum curriculum;

    /**
     * 所属课程编号 外键属性
     */
    @Transient
    private String curriculum_id;

    /**
     * 评论发送者编号 非空 最大8字节
     */
    @Column(nullable = false,length = 8)
    private String poster_id;

    /**
     * 要回复的评论的编号 非回复则设为-1
     */
    @Column
    private int reply_id;

    /**
     * 评论内容 非空 最大512字节
     */
    @Column(nullable = false,length = 512)
    private String content;

    /**
     * 评论发送时间 非空
     */
    @Column(nullable = false)
    private Date datetime;

    /**
     * 该评论是否置顶 非空
     */
    @Column(nullable = false)
    private Boolean top;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public String getPoster_id() {
        return poster_id;
    }

    public void setPoster_id(String poster_id) {
        this.poster_id = poster_id;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public String getCurriculum_id() {
        return curriculum_id;
    }

    public void setCurriculum_id(String curriculum_id) {
        this.curriculum_id = curriculum_id;
    }
}
