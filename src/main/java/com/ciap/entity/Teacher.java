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
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "teacher")
    private Set<Curriculum> curriculumSet;

    /**
     * 该教师上传的文件 一对多
     */
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "teacher")
    private Set<File> fileSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Curriculum> getCurriculumSet() {
        return curriculumSet;
    }

    public Set<File> getFileSet() {
        return fileSet;
    }
}
