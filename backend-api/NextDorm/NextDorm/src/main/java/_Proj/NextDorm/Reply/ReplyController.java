package _Proj.NextDorm.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping
    public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
        Reply createdReply = replyService.createReply(reply);
        return new ResponseEntity<>(createdReply, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reply>> getAllReplies() {
        List<Reply> replies = replyService.getAllReplies();
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reply> getReplyById(@PathVariable Long id) {
        Optional<Reply> reply = replyService.getReplyById(id);
        return reply.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Reply>> getReplyByPostId(@PathVariable Long postId) {
        List<Reply> replies = replyService.getReplyByPostId(postId);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Reply>> getReplyByStudentId(@PathVariable Long studentId) {
        List<Reply> replies = replyService.getReplyByStudentId(studentId);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reply> updateReply(@PathVariable Long id, @RequestBody Reply replyDetails) {
        try {
            Reply updatedReply = replyService.updateReply(id, replyDetails);
            return new ResponseEntity<>(updatedReply, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
