package com.ciap.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 学院
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_school")
public class School {
    /**
     * 学院编号 主键 最大2字节
     */
    @Id
    @Column(length = 2)
    private String id;

    /**
     * 学院名称 非空 不可重复 最大32字节
     */
    @Column(nullable = false,length = 32)
    private String name;

    /**
     * 该学院开设的课程 一对多
     */
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "school")
    private Set<Curriculum> curriculumSet;

    /**
     * 该学院就职的教师 一对多
     */
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "school")
    private Set<Teacher> teacherSet;
}
