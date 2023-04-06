	package ezen.springmvc.thymeleaf.controller;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
	public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	// 글 작성 처리
	public void write(Board board) {
		
		boardRepository.save(board);
		
	}
	
	
	// 게시글 리스트 처리
	public Page<Board> boardList(Pageable pageable){
		
		//.findAll=> db에 저장된 모든 board 객체 조회
		return boardRepository.findAll(pageable);
	}
	
	public Page<Board> boardSearchList(String searchKeyword, Pageable pageable){
       
	return boardRepository.findByTitleContaining(searchKeyword, pageable);

	}
	
	    // 특정 게시글 불러오기
	public Board boardView(Integer id) {
		
		return boardRepository.findById(id).get();
	}
	
	
	    //게시판 날짜
	 public Board boardInsert(Board board) {
	        Board newBoard = new Board();
	        newBoard.setCreatedDate(board.getCreatedDate());
	        //.save=> db에 저장
	        return boardRepository.save(newBoard);
	    }
	 
	 
	 //조회수 처리
	    @Transactional
	 public void increaseViewCount(int id) {
	        Board board = boardRepository.findById(id)
	        		//. orElseThrow() 메서드를 사용하여 Optional 객체가 비어있는 경우, IllegalArgumentException 예외를 발생시킴
	            .orElseThrow(() -> new IllegalArgumentException("Invalid board Id: " + id));
	        board.setViewCount(board.getViewCount() + 1);
	        boardRepository.save(board);
	        
	        
	 }
       
	
	}
