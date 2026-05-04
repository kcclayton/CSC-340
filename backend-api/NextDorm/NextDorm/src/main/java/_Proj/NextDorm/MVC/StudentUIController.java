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
import org.springframework.web.bind.annotation.RequestParam;

import _Proj.NextDorm.Post.Post;
import _Proj.NextDorm.Post.PostService;
import _Proj.NextDorm.Reply.Reply;
import _Proj.NextDorm.Reply.ReplyService;
import _Proj.NextDorm.Student.Student;
import _Proj.NextDorm.Student.StudentService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class StudentUIController {

    @Autowired
    private StudentService studentService;

    @Autowired 
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    //Getting all posts
    @GetMapping
    public String getAllComments(Model model, HttpSession session) {
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        
        model.addAttribute("commentsList", postService.getAllPosts());
        model.addAttribute("student", student);
        return "comments-list";
    }

    //Creating a post
    @GetMapping("/posts/create")
    public String showCreatePostPage(Model model) {
        model.addAttribute("post", new Post());
        return "create-post";
    }

    //Getting all posts from a certain residence hall
    @GetMapping("posts/{residenceHall}")
    public String getCommentsByHall(Model model, @PathVariable String residenceHall){
        model.addAttribute("commentsHallList", postService.getPostsByHall(residenceHall));
        return "comments-hall-list";

    }

    //Creating a reply to a post
    @GetMapping("/replies/create/{postID}")
    public String showCreateReplyPage(Model model, @PathVariable Long postID) {
        Post post = postService.getPostById(postID).orElse(null);

        model.addAttribute("reply", new Reply());
        model.addAttribute("post", post);
        return "create-reply";
    }

    //Posting a reply to a post
    @PostMapping("/replies/create/{postID}")
    public String createReply(@ModelAttribute Reply reply, @PathVariable Long postID, HttpSession session) {
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        reply.setStudent(student);

        Post post = postService.getPostById(postID).orElse(null);
        reply.setPost(post);
        replyService.createReply(reply);

        return "redirect:/students";
    }

    //Creating a post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, HttpSession session) {
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        post.setStudent(student);

        postService.createPost(post);

        return "redirect:/students";
    }

    //Getting a student by their id to display on the profile page
    @GetMapping("/{id}")
    public String getStudentByID(@PathVariable Long id, Model model, HttpSession session) {
    Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        model.addAttribute("student", student);

    
    if (student != null) {
      return "profile";
    } else {
      return "comments-list";
    }
  }

    //Rendering the signin page
    @GetMapping("/signin")
    public String showSigninPage() {
        return "signin"; 
    }

    //Trying to get a student by their username and password.
    @PostMapping("/signin")
    public String signin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        try {
        Student student = studentService.authenticate(email, password);
        session.setAttribute("studentID", student.getUserId());
        return "redirect:/students";
        } catch (Exception e) {
        return "redirect:/signin?error";
        }
    }
}
