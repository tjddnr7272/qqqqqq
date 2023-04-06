	package ezen.springmvc.restapi.comment;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import java.util.List;

	@Service
	public class CommentService {

	    @Autowired
	    private CommentRepository commentRepository;

	    public List<Comment> findByBoardId(Long boardId) {
	        return commentRepository.findByBoardId(boardId);
	    }

	    public Comment save(Comment comment) {
	        return commentRepository.save(comment);
	    }

	    // 기타 필요한 메소드 추가
	}