package com.wenqy.feign.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.wenqy.feign.upload.service.UploadService;

import lombok.SneakyThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ConsumerFeignUploadApplication.class)
public class UploadFileTester {

	@Autowired
    private UploadService uploadService;
	
    @Test
    @SneakyThrows
    public void testHandleFileUpload() throws InterruptedException {
    	// @see https://github.com/spring-cloud/spring-cloud-commons/issues/111
        File file = new File("upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);

        System.out.println("testHandleFileUpload：" + uploadService.handleFileUpload(multi));
    }
}
