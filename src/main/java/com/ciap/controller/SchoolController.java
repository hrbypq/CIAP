package com.ciap.controller;

import com.ciap.entity.School;
import com.ciap.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 学院控制类
 * @version 1.0
 * @author ypq
 */

@RestController
@RequestMapping("/school")
public class SchoolController {
    /**
     * School 服务类
     */
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/searchAllSchools")
    public List<School> searchAllSchools(){
        return schoolService.searchAllSchools();
    }
}
