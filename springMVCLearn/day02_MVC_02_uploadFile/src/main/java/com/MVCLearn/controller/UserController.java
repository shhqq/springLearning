package com.MVCLearn.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by s on 2020/6/28 11:14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 上传文件
     * 传统文件上传方式
     * @return
     */
    @RequestMapping("/testUploadFile")
    public String testUploadFile(HttpServletRequest request) throws Exception {
        System.out.println("testUploadFile method executed.");

        // 使用fileupload组件实现文件上传
        // 上传的位置
        String filePath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println("文件上传位置：" + filePath);

        // 判断该路径是否存在
        File file = new File(filePath);
        // 如果文件夹不存在，则创建该文件夹（在target目录下）
        if(!file.exists()){
            file.mkdir();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request，得到一个list集合
        List<FileItem> items = upload.parseRequest(request);
        System.out.println(items);
        // 遍历
        for(FileItem item: items){
            // 判断当前item对象是否是上传文件项
            if(item.isFormField()){
                // 为true，表明是普通表单项
                System.out.println("普通表单项");
            } else {
                // 为false，表明是上传文件项
                // 获取上传文件的名称
                System.out.println("上传文件项");
                String name = item.getName();
                System.out.println("file name: " + name);
                // 完成文件上传
                item.write(new File(filePath, name));

                // 删除临时文件
                item.delete();
            }
        }

        return "success";
    }
}
