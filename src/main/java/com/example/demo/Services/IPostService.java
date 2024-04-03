package com.example.demo.Services;

import com.example.demo.Model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public interface IPostService {

    void createPost(String title,String content, String category);
    List<Post> getAllPosts();

    void deletePost(int id);

    void updatePost(int id, String NewTitle, String NewContent, String NewCategory);

    Post getPostById(int id);
}
