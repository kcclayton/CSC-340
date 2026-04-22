package _Proj.NextDorm.MVC;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import _Proj.NextDorm.Post.Post;
import _Proj.NextDorm.Post.PostService;
import _Proj.NextDorm.Reply.Reply;
import _Proj.NextDorm.Reply.ReplyService;
import _Proj.NextDorm.Student.Student;
import _Proj.NextDorm.Student.StudentService;

@Controller
@RequestMapping("/students")
public class StudentUIController {

    @Autowired
    private StudentService studentService;

    @Autowired 
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    @GetMapping
    public String getAllComments(Model model) {
        model.addAttribute("commentsList", postService.getAllPosts());
        return "comments-list";
    }

    @GetMapping("/posts/create")
    public String showCreatePostPage(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @GetMapping("/replies/create/{postID}")
    public String showCreateReplyPage(Model model, @PathVariable Long postID) {
        model.addAttribute("reply", new Reply());
        model.addAttribute("postId", postID);
        return "create-reply";
    }

    @PostMapping("/replies/create/{postID}")
    public String createReply(@ModelAttribute Reply reply, @PathVariable Long postID) {

        Student student = studentService.getStudentById(1L).orElse(null);
        reply.setStudent(student);

        Post post = postService.getPostById(postID).orElse(null);
        reply.setPost(post);
        replyService.createReply(reply);

        return "redirect:/students";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

        Student student = studentService.getStudentById(1L).orElse(null);
        post.setStudent(student);

        postService.createPost(post);

        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String getStudentByID(@PathVariable Long id, Model model) {
    Student student = studentService.getStudentById(id).orElse(null);
    model.addAttribute("student", student);

    
    if (student != null) {
      return "profile";
    } else {
      return "comments-list";
    }
  }



    
}
