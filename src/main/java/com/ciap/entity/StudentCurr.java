package com.ciap.entity;

import javax.persistence.*;

/**
 * 学生-课程关系 中间表
 * @version 1.0
 * @author ypq
 */

@Entity
@Table(name = "t_student_curr")
public class StudentCurr {

    /**
     * id 自增int型主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 学生id 非空
     */
    @Column(nullable = false,length = 8)
    private String studentId;

    /**
     * 课程id 非空
     */
    @Column(nullable = false,length = 32)
    private String currId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCurrId() {
        return currId;
    }

    public void setCurrId(String currId) {
        this.currId = currId;
    }
}
