package com.ciap.controller;

import com.ciap.dao.CurriculumRepository;
import com.ciap.dao.TeacherRepository;
import com.ciap.entity.Curriculum;
import com.ciap.entity.Material;
import com.ciap.entity.Teacher;
import com.ciap.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 文件控制类
 * @version 1.0
 * @author ypq
 */

@RestController
@RequestMapping("/material")
public class MaterialController {

    /**
     * Material服务类
     */
    @Autowired
    private MaterialService materialService;

    @Autowired
    private CurriculumRepository curriculumRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * 查询某课程下的全部文件记录
     * @param a_curr_id 课程id
     * @return 文件记录list
     */
    @GetMapping("/searchMaterialByCurrId/{a_curr_id}")
    public List<Material> searchMaterialByCurrId(@PathVariable("a_curr_id") String a_curr_id){
        return materialService.searchAllByCurrId(a_curr_id);
    }

    @PostMapping("/uploadMaterial/{a_curr_id}/{a_teacher_id}")
    public boolean uploadMaterial(@PathVariable("a_curr_id") String a_curr_id, @PathVariable("a_teacher_id") String a_teacher_id, MultipartFile file){
        if(file==null)
            return false;
        if(file.isEmpty())
            return false;
        String path = "D:\\CIAP_test\\" + a_curr_id + "\\" + file.getOriginalFilename();
        File dest = new File(path);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest); //保存文件
            Optional<Curriculum> curriculum=curriculumRepository.findById(a_curr_id);
            Optional<Teacher> teacher=teacherRepository.findById(a_teacher_id);
            if(curriculum.isEmpty()||teacher.isEmpty())
                return false;
            Material material = new Material();
            material.setId(0);
            material.setCurriculum(curriculum.get());
            material.setTeacher(teacher.get());
            material.setDatetime(new Date());
            material.setUrl(path);
            materialService.createMaterial(material);  //保存文件记录
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/downloadMaterial/{a_id}")
    public void downloadMaterial(@PathVariable("a_id") int a_id, HttpServletResponse response) throws IOException {
        Optional<Material> material=materialService.searchMaterialById(a_id);
        if(material.isEmpty())
            return;
        File file = new File(material.get().getUrl());
        FileInputStream fileInputStream=new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fileInputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        fileInputStream.close();
    }

    /**
     * 删除文件
     * @param a_id 文件id
     * @return 是否删除成功
     */
    @DeleteMapping("deleteMaterial/{a_id}")
    public boolean deleteMaterialById(@PathVariable("a_id") int a_id){
        Optional<Material> material=materialService.searchMaterialById(a_id);
        if(material.isEmpty()) return false;
        File file=new File(material.get().getUrl());
        if(file.delete()) return materialService.deleteMaterial(a_id);
        return false;
    }

}
