package com.example.www.Controller;

import cn.hutool.core.io.FileUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    String path="D:\\Xnew\\www\\myvue\\src\\assets\\";
    @PostMapping()
    public String upload(MultipartFile file) throws IOException {
        String filename=file.getOriginalFilename();
        String realpath=path+filename;
        File localFile=new File(realpath);
        file.transferTo(localFile);
        String url="http://localhost:8080/upload/"+filename;
        return url;
    }
 @GetMapping("/{fileName}")
    public void downLoad(@PathVariable String fileName, HttpServletResponse response) throws IOException {
     response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName, StandardCharsets.UTF_8));
     String realpath=path+fileName;
     byte[] bytes=FileUtil.readBytes(realpath);
     ServletOutputStream os=response.getOutputStream();
     os.write(bytes);
     os.flush();
     os.close();
 }
}
