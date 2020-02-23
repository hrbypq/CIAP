package com.ciap.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 课程
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_curriculum")
public class Curriculum {
    /**
     * 课程编号 主键 最大32字节
     */
    @Id
    @Column(length = 32)
    private String id;

    /**
     * 课程名称 非空 最大64字节
     */
    @Column(nullable = false,length = 64)
    private String name;

    /**
     * 学院编号 外键指向school表主键 字段名school_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "school_id",nullable = false)
    private School school;

    /**
     * 学院编号 外键属性
     */
    @Transient
    private String school_id;

    /**
     * 教师编号 外键指向teacher表主键 字段名teacher_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;

    /**
     * 教师编号 外键属性
     */
    @Transient
    private String teacher_id;

    /**
     * 本课程下的评论 一对多
     */
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "curriculum")
    private List<Comment> commentSet;

    /**
     * 本课程的文件 一对多
     */
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "curriculum")
    private List<Material> materialSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Comment> getCommentSet() {
        return commentSet;
    }

    public List<Material> getMaterialSet() {
        return materialSet;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}
