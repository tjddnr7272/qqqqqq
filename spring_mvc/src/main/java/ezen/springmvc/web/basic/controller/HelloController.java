package ezen.springmvc.web.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// hello.do 요청에 대한 세부 컨트롤러
@Controller
public class HelloController {
	
	//언제실행?
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		String message = "안녕하세요. Spring MVC";
		ModelAndView mav = new ModelAndView();
		mav.addObject("message" ,message);
		mav.setViewName("hello"); //파일이름 적기! (.jsp는 뺴도 됨)
		return mav;
	}

}
