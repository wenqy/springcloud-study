package com.wenqy.feign.upload.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * feign upload
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@RestController
public class ProviderFeignUploadDemoController {
	
	/**
	 * feign upload
	 * @param file
	 * @return
	 * @author wenqy
	 * @date 2020年1月8日 上午11:38:38
	 */
	@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        return file.getOriginalFilename();
    }
}
