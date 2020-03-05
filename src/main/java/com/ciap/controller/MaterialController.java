package com.ciap.controller;

import com.ciap.dao.CurriculumRepository;
import com.ciap.dao.TeacherRepository;
import com.ciap.entity.Material;
import com.ciap.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/searchMaterialByCurrId/{a_curr_id}")
    public List<Material> searchMaterialByCurrId(@PathVariable("a_curr_id") String a_curr_id){
        return materialService.searchAllByCurrId(a_curr_id);
    }

    @PostMapping("/uploadMaterial/{a_curr_id}/{a_teacher_id}")
    public boolean uploadMaterial(@PathVariable("a_curr_id") String a_curr_id, @PathVariable("teacher_id") String a_teacher_id, MultipartFile file){
        if(file==null)
            return false;
        if(file.isEmpty())
            return false;
        String path = "D:\\CIAP_test\\" + a_curr_id + "\\" + file.getOriginalFilename();
        File dest = new File(path);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            Material material = new Material();
            material.setId(0);
            material.setCurriculum(curriculumRepository.findById(a_curr_id).get());
            material.setTeacher(teacherRepository.findById(a_teacher_id).get());
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

    @GetMapping("/downloadMaterial/{a_curr_id}/{material_id}")
    public String downloadMaterial(@PathVariable("a_curr_id") String a_curr_id, @PathVariable("material_id") int material_id, HttpServletResponse response){
        String filepath=materialService.searchMaterialById(material_id).get().getUrl();
        File file=new File(filepath);
        if(file.exists()){
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;
            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }


}
