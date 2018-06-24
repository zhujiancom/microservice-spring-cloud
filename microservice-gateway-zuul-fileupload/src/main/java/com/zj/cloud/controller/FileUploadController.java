package com.zj.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Creator: zhuji
 * Date: 5/22/2018
 * Time: 11:23 AM
 * Description:
 *
 * 测试方法：
 * 1. 有界面的测试： 访问地址 http://localhost:8050/index.html
 * 2. 使用curl 命令： curl -F "file=@文件全名" localhost:8050/upload
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam(value = "file" , required = true)MultipartFile file) throws Exception{
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileToSave);
        return fileToSave.getAbsolutePath();
    }
}
