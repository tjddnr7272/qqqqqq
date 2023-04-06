package ezen.springmvc.thymeleaf.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


// @Mapper => 마이바티스와 인터페이스 함수를 연결시킴
@Mapper
public interface INoticeDao {
    public List<NoticeDto> list();
    
    public int write(String notice_title, String notice_content);
    
    public NoticeDto viewDto(String notice_id);
    
    public int updateDto(String notice_id, String notice_title, String notice_content);
    	
}
