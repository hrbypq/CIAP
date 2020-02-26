package com.ciap.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 文件
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_file")
public class Material {
    /**
     * 文件编号 主键 自动生成
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 文件上传时间 非空
     */
    @Column(nullable = false)
    private Date datetime;

    /**
     * 文件url 非空 不可重复 最大512字节
     */
    @Column(nullable = false,unique = true,length = 512)
    private String url;

    /**
     * 文件所属的课程编号 外键指向课程表主键 字段名称curriculum_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "curriculum_id",nullable = false)
    private Curriculum curriculum;

    /**
     * 文件所属的课程编号 外键属性
     */
    @Transient
    private String curriculum_id;

    /**
     * 上传本文件的教师 外键指向教师表主键 字段名称teacher_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;

    /**
     * 上传本文件的教师编号 外键属性
     */
    @Transient
    private String teacher_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCurriculum_id() {
        return curriculum_id;
    }

    public void setCurriculum_id(String curriculum_id) {
        this.curriculum_id = curriculum_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}