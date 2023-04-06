package ezen.springmvc.restapi.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{boardId}")
    public List<Comment> findByBoardId(@PathVariable Long boardId) {
        return commentService.findByBoardId(boardId);
    }

    @PostMapping
    public Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

}
