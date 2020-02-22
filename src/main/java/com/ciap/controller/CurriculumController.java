package com.ciap.controller;

import com.ciap.entity.Curriculum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程控制类
 * @version 1.0
 * @author
 */

@RestController
@RequestMapping("/curr")
public class CurriculumController {
    @GetMapping("/searchCurrByName")
    public Curriculum searchCurrByName(){
        return null;
    }
}
