package com.ciap.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 教师
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_teacher")
public class Teacher {
    /**
     * 教师编号 主键 最大8字节
     */
    @Id
    @Column(length = 8)
    private String id;

    /**
     * 密码 非空 最大16字节
     */
    @Column(nullable = false,length = 16)
    private String password;

    /**
     * 姓名 非空 最大32字节
     */
    @Column(nullable = false,length = 32)
    private String name;

    /**
     * 教师自我简介 非空 最大512字节
     */
    @Column(nullable = false,length = 512)
    private String intro;

    /**
     * 邮箱 可空 不可重复 最大32字节
     */
    @Column(unique = true,length = 32)
    private String email;

    /**
     * 学院编号 外建指向school表主键 字段名school_id 非空
     */
    @ManyToOne
    @JoinColumn(name = "school_id",nullable = false)
    private School school;

    /**
     * 该教师开设的课程 一对多
     */
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "teacher")
    private Set<Curriculum> curriculumSet;
}
