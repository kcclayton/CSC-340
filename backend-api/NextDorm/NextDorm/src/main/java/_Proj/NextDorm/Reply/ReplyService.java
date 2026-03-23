package _Proj.NextDorm.Reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {
    
    @Autowired
    private ReplyRepository replyRepository;

    
    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }
    
    public Optional<Reply> getReplyById(Long id) {
        return replyRepository.findById(id);
    }
    
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

     public List<Reply> getReplyByPostId(Long postId) {
        return replyRepository.findByPostId(postId);
    }

      public Reply updateReply(Long id, Reply replyDetails) {
        return replyRepository.findById(id).map(reply -> {
            reply.setReplyContent(replyDetails.getReplyContent());
            return replyRepository.save(reply);
        }).orElseThrow(() -> new RuntimeException("Reply not found"));
    }

    public List<Reply> getReplyByStudentId(Long studentId){
        return replyRepository.findByStudentId(studentId);
    }

     public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }

}
