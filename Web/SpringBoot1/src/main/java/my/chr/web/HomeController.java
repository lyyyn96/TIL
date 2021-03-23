package my.chr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 해줘야 컨트롤러가 됨
@Controller
public class HomeController {
	
	@ResponseBody
	@RequestMapping("/home.chr")
	public String home() {
		System.out.println("Hello 최혜린~!");
		return "Hello 혜린!!"; //jsp는 띄어쓰기, !불가. jsp가 아니라 일반 문자열 return
	}
}
