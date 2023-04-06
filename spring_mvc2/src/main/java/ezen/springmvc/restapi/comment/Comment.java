package ezen.springmvc.restapi.comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_id", nullable = false)
    private Long boardId;

    @Column(name = "content", nullable = false, columnDefinition = "CLOB")
    private String content;



	@Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;



	

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Comment(Long id, Long boardId, String content, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.content = content;
		this.createdAt = createdAt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getBoardId() {
		return boardId;
	}



	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

    // 기본 생성자, 게터, 세터, 기타 메소드 생략
	
	
	
	
	
	
	
}

