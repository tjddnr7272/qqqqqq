	package ezen.springmvc.thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
	public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/board/write")
	public String boardWriteForm(Model model) {
		//model.addAttribute() 메소드를 사용하여 Model 객체에 데이터를 추가해서, 이 데이터를 뷰에서 ${} 형식으로 표현되어 화면에 표시되게 함
	    model.addAttribute("board", new Board());
	    return "basic/createNotice";
	}
	   
	   
	
	   
	   
	   
	@PostMapping("/board/writepro")
	//@ModelAttribute("board")는 바인딩된 Board 객체를 뷰에서 ${board}와 같은 형식으로 사용할 수 있도록 함(name으로 안받을때)
	public String boardWritePro(@Validated @ModelAttribute("board") Board board, BindingResult result, Model model) {
	    
		if (result.hasErrors()) {
	        model.addAttribute("errors", result.getAllErrors());
	        return "basic/createNotice";
	    }
	    	
	    boardService.write(board);
	    return "redirect:/board/list";	   
	}
	   	   
	
		   @GetMapping("/board/list")
		   public String boardList(Model model,
                   @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                   String searchKeyword) {
			   					   
			   //초기화 해주고
			   Page<Board> list = null;
			   
			   // 검색단어가 안들어왔을때 => 기존에 보여주던 리스트 보여줌(pageable)
			   if(searchKeyword == null) {
				   
				  list = boardService.boardList(pageable);
				   
			   }else {
				   // 검색 단어가 들어왔을때 => 실행됨
				   list = boardService.boardSearchList(searchKeyword,pageable);
			   }
			   
			   
			   int nowPage = list.getPageable().getPageNumber() + 1;
		        int startPage = Math.max(nowPage - 4, 1);
		        int endPage = Math.min(nowPage + 5, list.getTotalPages());
			   
			   
			   
			   // boardService.boardList() 반환값을 list 라는 이름으로 넘김
			   model.addAttribute( "list", list);
			   model.addAttribute( "nowPage", nowPage);
			   model.addAttribute( "startPage", startPage);
			   model.addAttribute( "endPage", endPage);
			
			   return  "basic/boardlist";
		   }
		   
		   
		  
		   
		   
		   
		   
		
		   
		   @GetMapping("/board/view")
		    public String boardview(Model model, Integer id) {
		        if (id == null) {
		            // id 값이 null인 경우 처리

		            throw new IllegalArgumentException("게시물 ID가 잘못되었습니다.");

		        }

		        boardService.increaseViewCount(id);
		        model.addAttribute("board", boardService.boardView(id));

		        return "basic/boardview";
		    }

	    
	}
