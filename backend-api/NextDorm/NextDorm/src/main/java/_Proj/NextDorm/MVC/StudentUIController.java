package _Proj.NextDorm.MVC;

import java.util.List;
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
import _Proj.NextDorm.Events.*;
import _Proj.NextDorm.Bans.*;
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

    @Autowired 
    private EventService eventService;

    @Autowired
    private BanService banService;


    //Getting a list of all of the events posted by RAs
    @GetMapping("/events")
    public String getAllEvents(Model model, HttpSession session){
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        
        model.addAttribute("eventsList", eventService.getAllEvents());
        model.addAttribute("student", student);
        return "events";
    }

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
    public String showCreatePostPage(Model model, HttpSession session) {
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        List<Ban> bans = banService.getBansByStudent(studentID);
        
        if (!bans.isEmpty()){
            model.addAttribute("ban", bans.get(0));
            return "student-ban";
        }
        
        model.addAttribute("post", new Post());
        model.addAttribute("student", student);
        return "create-post";
    }

     @GetMapping("/posts/important")
    public String getCommentsByImportant(Model model, HttpSession session){
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);

        model.addAttribute("student", student);
        model.addAttribute("importantList", postService.getEmergencyTag());
        return "comments-important-list";
    }

    //Getting all posts from a certain residence hall
    @GetMapping("/posts/{residenceHall}")
    public String getCommentsByHall(Model model, @PathVariable String residenceHall, HttpSession session){
        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);

        model.addAttribute("student", student);
        model.addAttribute("commentsHallList", postService.getPostsByHall(residenceHall));
        return "comments-hall-list";

    }

   

    //Creating a reply to a post
    @GetMapping("/replies/create/{postID}")
    public String showCreateReplyPage(Model model, @PathVariable Long postID, HttpSession session) {
        Post post = postService.getPostById(postID).orElse(null);

        Long studentID = (Long) session.getAttribute("studentID");

        if (studentID == null) {
            return "redirect:/students/signin";
        }

        Student student = studentService.getStudentById(studentID).orElse(null);
        List<Ban> bans = banService.getBansByStudent(studentID);
        
        if (!bans.isEmpty()){
            model.addAttribute("ban", bans.get(0));
            return "student-ban";
        }

        model.addAttribute("student", student);
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

    //Rendering the sign-in page
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

    //Rendering the sign-up page
    @GetMapping("/signup")
    public String showSignupPage(){
        return "signup";
    }

    //Posting the newly created student
    @PostMapping("/signup")
    public String createNewStudent(Student student){
        studentService.createStudent(student);
        return "redirect:/students/signin";
    }

    //Signing out of the current HTTP session
    @GetMapping("/auth/signout")
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:/students/signin";
    }


    //Get mapping for updating the current user
    @GetMapping("/update/{id}")
    public String showProfilePage(@PathVariable Long id, Model model, HttpSession session){
            Long studentID = (Long) session.getAttribute("studentID");

            if (studentID == null) {
                return "redirect:/students/signin";
            }

            Student student = studentService.getStudentById(studentID).orElse(null);
            model.addAttribute("student", student);

            return "personal-profile";
    }


    //Post mapping for updating the current user
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        
        if (student != null) {
        return "redirect:/students/update/" + student.getUserId();
        } else {
        return "redirect:/students/" + id + "?error=true";
        }
    }

    @PostMapping("/delete")
    public String deleteStudent(HttpSession session){
        Long studentID = (Long) session.getAttribute("studentID");
        studentService.deleteStudent(studentID);
        session.invalidate();

        return "redirect:/students/signin";
    }

}
