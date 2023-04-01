package com.aiguigu.boot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String Up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException
    {
        System.out.println(nickname);
        System.out.println(photo.getOriginalFilename());
        //System.out.println(System.getProperty("user.dir"));

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo,path);
        return "上传成功";
    }

    public void saveFile(MultipartFile photo, String path)throws IOException{
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }

        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }
}


