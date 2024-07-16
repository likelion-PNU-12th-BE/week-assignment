package study.likelionbeweekly.week7.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.likelionbeweekly.week7.comment.dto.CreateCommentRequest;
import study.likelionbeweekly.week7.comment.dto.UpdateCommentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateCommentRequest request) {
        commentService.createComment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }

    /*
    @GetMapping
    */

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,
                                         @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(id, request);
        return ResponseEntity.ok().body("ok");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().body("ok");
    }
}


