package com.wenqy.feign.upload.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * feign upload 接口
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@FeignClient(value = "provider-feign-demo", configuration = UploadService.MultipartSupportConfig.class)
public interface UploadService {

	@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);
 
    @Configuration
    class MultipartSupportConfig {
    	
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
