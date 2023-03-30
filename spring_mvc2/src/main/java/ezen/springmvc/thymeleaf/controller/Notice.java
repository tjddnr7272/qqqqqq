package ezen.springmvc.thymeleaf.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private LocalDateTime createdDate;

    private Long viewCount;

    // Getter, Setter, 생성자 등 생략
}
