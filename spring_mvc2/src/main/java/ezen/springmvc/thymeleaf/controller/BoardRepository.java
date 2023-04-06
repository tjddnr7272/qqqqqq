package ezen.springmvc.thymeleaf.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


// 데이터베이스에 대한 CRUD(Create, Read, Update, Delete) 작업을 수행하는 메서드를 선언하고 있는 인터페이스
public interface BoardRepository extends JpaRepository<Board, Integer>{

	Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
	
}
