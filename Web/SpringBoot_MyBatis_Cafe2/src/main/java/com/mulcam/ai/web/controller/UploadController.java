package com.mulcam.ai.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController // @Controller(.jsp를 지정하고 싶으면 그냥 Controller)+@ReponseBody(직접 out buffer에 데이터 보냄)
public class UploadController {
	
	@PostMapping("/upload") // @RequestMapping의 method가 POST
	//비동기로 하려면 return type을 String이 아니라 void를 이용
	public String upload(@RequestParam("file") MultipartFile file) {
		//이미지를 다시 후처리 해줘야 하는데 그것을 해주는 것이 MultipartFile 객체
		System.out.println(file);
		
		try {
			file.transferTo(new File("d:\\tool\\temp\\"+file.getOriginalFilename()));
			return "upload ok";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return "upload fail";
		} catch (IOException e) {
			e.printStackTrace();
			return "upload fail";
		}
	}
	
}
