package com.ciap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 课程信息
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_currinfo")
public class CurrInfo {
    /**
     * 课程编号 主键 最大32字节
     */
    @Id
    @Column(length = 32)
    private String id;

    /**
     * 课程简介 非空 最大512字节
     */
    @Column(nullable = false,length = 512)
    private String info;

    /**
     * 先修课程 非空 最大128字节
     */
    @Column(nullable = false,length = 128)
    private String prerequisite;

    /**
     * 推荐书目 非空 最大128字节
     */
    @Column(nullable = false,length = 128)
    private String book;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
