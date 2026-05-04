package _Proj.NextDorm.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

     public Post createPost(Post post) {
        return postRepository.save(post);
    }
    
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }
    
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByHall(String residenceHall){
        return postRepository.findByStudent_ResidenceHall(residenceHall);
    }

    public List<Post> getPostsByStudentId(Long studentID) {
        return postRepository.findByStudentId(studentID);
    }

     public Post updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(post -> {
            post.setPostTitle(postDetails.getPostTitle());
            post.setPostContent(postDetails.getPostContent());
            post.setPostTag(postDetails.getPostTag());
            return postRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found"));
    }

     public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
