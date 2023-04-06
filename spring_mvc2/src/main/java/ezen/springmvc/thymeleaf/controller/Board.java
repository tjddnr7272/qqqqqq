package ezen.springmvc.thymeleaf.controller;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.repository.Temporal;

import lombok.Data;
@Data
@Entity


public class Board {
  
   //pk값
    

    
    // 오라클에서 사용함
    @Id
    @SequenceGenerator(name = "board_seq_generator", sequenceName = "BOARD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generator")    
     private Integer id;
   
    
    
    
    @Column(name = "title", nullable = false)
    @NotEmpty(message = "제목을 입력해주세요.")
    @Size(max = 255, message = "제목은 최대 255자까지 입력 가능합니다.")
     private String title;
    
    
    
    

    @Column(name = "content", nullable = false, columnDefinition = "CLOB")
    @NotEmpty   (message = "내용을 입력해주세요.")   
    private String content;
    
    
    
    @Column(name = "created_date", nullable = false, updatable = false)
    private Timestamp createdDate;

    
    
    @Column(name = "view_count", nullable = false)
    private int viewCount;
    
    @NotEmpty
    @Column(name = "email", nullable = false)
    @Email(message = "이메일 형식으로 입력해주세요.(abc@hanmail.net)")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public int getViewCount() {
      return viewCount;
   }


   public void setViewCount(int viewCount) {
      this.viewCount = viewCount;
   }
   
   
   


   public Board() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }
  
   
   public Timestamp getCreatedDate() {
      return createdDate;
   }
   
   
   public void setCreatedDate(Timestamp createdDate) {
      this.createdDate = createdDate;
   }
    
   
    
   public Integer getId() {
      return id;
   }
   public void setId(Integer id) {
      this.id = id;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
    
    
    
//    private Date noticeDate;
//    private int field;
    
    
    
    


}