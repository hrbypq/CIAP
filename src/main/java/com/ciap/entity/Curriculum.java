package com.ciap.entity;

import javax.persistence.*;

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
     * 教师编号 外键指向teacher表主键 字段名teacher_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;
}
