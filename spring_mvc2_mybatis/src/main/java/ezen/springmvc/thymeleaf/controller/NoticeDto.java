package ezen.springmvc.thymeleaf.controller;

import java.util.Date;



public class NoticeDto {
   private int notice_id;
   private String notice_title;
   private String notice_content;
   private Date notice_date;
   private int notice_hit;
   
   public NoticeDto() {}
   
  public NoticeDto(int notice_id, String notice_title, String notice_content, Date notice_date, int notice_hit) {
	super();
	this.notice_id = notice_id;
	this.notice_title = notice_title;
	this.notice_content = notice_content;
	this.notice_date = notice_date;
	this.notice_hit = notice_hit;
	
}

public int getNotice_id() {
	return notice_id;
}

public void setNotice_id(int notice_id) {
	this.notice_id = notice_id;
}

public String getNotice_title() {
	return notice_title;
}

public void setNotice_title(String notice_title) {
	this.notice_title = notice_title;
}

public String getNotice_content() {
	return notice_content;
}

public void setNotice_content(String notice_content) {
	this.notice_content = notice_content;
}

public Date getNotice_date() {
	return notice_date;
}

public void setNotice_date(Date notice_date) {
	this.notice_date = notice_date;
}

public int getNotice_hit() {
	return notice_hit;
}

public void setNotice_hit(int notice_hit) {
	this.notice_hit = notice_hit;
}

@Override
public String toString() {
	return "NoticeDto [notice_id=" + notice_id + ", notice_title=" + notice_title + ", notice_content=" + notice_content
			+ ", notice_date=" + notice_date + ", notice_hit=" + notice_hit + "]";
}
    
    
    


}