package com.example.demo.Controllers;

import ch.qos.logback.core.model.Model;
import com.example.demo.Model.Post;
import com.example.demo.Services.IPostService;
import com.example.demo.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/posts")
    public ModelAndView getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        ModelAndView modelAndView = new ModelAndView("posts");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }


    @PostMapping("/create")
    @ResponseBody
    public String createPost(@RequestParam String title, @RequestParam String content, @RequestParam String category) {
        postService.createPost(title, content, category);
        return "Post created successfully";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "Post deleted successfully";
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public String updatePost(@PathVariable int id, @RequestParam String newTitle, @RequestParam String newContent, @RequestParam String newCategory) {
        Post post = postService.getPostById(id);
        if (post != null) {
            post.setTitle(newTitle);
            post.setContent(newContent);
            post.setCategory(newCategory);
            postService.updatePost(post.getId(),post.getTitle(),post.getContent(),post.getCategory());
            return "Post updated successfully";
        } else {
            return "Post not found";
        }
    }

}