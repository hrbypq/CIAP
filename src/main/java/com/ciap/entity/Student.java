package com.ciap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生类
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_student")
public class Student {
    /**
     * 学号 主键 最大8位
     */
    @Id
    @Column(length = 8)
    private String no;

    /**
     * 姓名 非空 最大32字节
     */
    @Column(nullable = false,length = 32)
    private String name;

    /**
     * 邮箱 可空 不可重复 最大32字节
     */
    @Column(unique = true,length = 32)
    private String email;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(String no, String name, String email) {
        this.no = no;
        this.name = name;
        this.email = email;
    }

    public Student() {
    }
}
