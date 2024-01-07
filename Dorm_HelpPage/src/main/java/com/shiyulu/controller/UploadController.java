package com.shiyulu.controller;

import com.shiyulu.pojo.Result;
import com.shiyulu.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    //oss阿里云存储文件

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名: {}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成,文件访问的url: {}",url);
        return Result.success(url);
    }
}
