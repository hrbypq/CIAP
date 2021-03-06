package com.ciap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_student")
public class Student {
    /**
     * 学号 主键 最大8字节
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
}
