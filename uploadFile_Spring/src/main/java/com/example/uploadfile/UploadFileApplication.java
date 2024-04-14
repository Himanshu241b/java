package com.example.uploadfile;

import com.example.uploadfile.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadFileApplication.class, args);
	}

}
