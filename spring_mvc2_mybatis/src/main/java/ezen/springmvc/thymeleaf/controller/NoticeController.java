	package ezen.springmvc.thymeleaf.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
	public class NoticeController {
	
	@Autowired
	INoticeDao noticeDao;
	@Autowired
	private HttpServletRequest request;

	
	
	@RequestMapping ("/")
//	@ResponseBody
	public String root() {
//		return "root() 함수 호출됨."; //문자열로 반환
		return "redirect:listForm";
		
	}
	
    @RequestMapping("/listForm")
    public String listForm(Model model) {
    	List<NoticeDto> list = noticeDao.list();
    	model.addAttribute("list",list);
    	
    	System.out.println(list);
    	
    	return "listForm";  
    }
    
    @RequestMapping("/writeForm")
    public String writeForm() {
    	
    	return "writeForm"; 
    }
    @RequestMapping("/writeAction")
    public String writeAction(@RequestParam("notice_title")String notice_title,
    		@RequestParam("notice_content")String notice_content) 
    {
    	int result = noticeDao.write(notice_title,notice_content);
    	if(result == 1) {
    		System.out.println("글쓰기 성공했습니다..");
    		request.getSession().setAttribute("alert_message","글쓰기 성공!");
    		return "redirect:listForm;";
    		
    	}else {
    		System.out.println("글쓰기 실패했습니다..");
    		request.getSession().setAttribute("alert_message","글쓰기 실패!");
    		return "redirect:writeForm;";
    }
  }

  @RequestMapping("/contentForm")
  public String contentForm(@RequestParam("notice_id")String notice_id,
		  Model model)
  {
	  NoticeDto dto = noticeDao.viewDto(notice_id);
	  
	  System.out.println(dto);
	  
	  model.addAttribute("dto", dto);
	  
	return  "contentForm";
	  
  }

  @RequestMapping("/updateAction")
  public String updateAction(@RequestParam("notice_id")String notice_id,
		                     @RequestParam("notice_title")String notice_title,  
		                     @RequestParam("notice_content")String notice_content,
		                     HttpServletRequest request) {
	  
	  
	
		
	  int result = noticeDao.updateDto(notice_id , notice_title, notice_content);
			  if(result == 1) {
		    		System.out.println("글수정 성공했습니다..");
		    		request.getSession().setAttribute("alert_message","글수정 성공!");
		    		return "redirect:listForm;";
		    		
		    		
		    	}else {
		    		System.out.println("글수정 실패했습니다..");
		    		request.getSession().setAttribute("alert_message","글수정 실패!");
		    		return "redirect:updateForm?notice_id=" + notice_id; //updateForm으로 리다이렉트함
	  
  }
  

  }
    
    

}