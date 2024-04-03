package com.example.demo.Services;

import com.example.demo.DataAccess.DatabaseManager;
import com.example.demo.Model.Post;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService{

    @Override
    public void createPost(String title, String content, String category)
    {
        DatabaseManager.MakePost(title,content,category);
    }

    @Override
    public List<Post> getAllPosts() {
        return DatabaseManager.getAllPosts();
    }

    @Override
    public void deletePost(int id) {
        DatabaseManager.deletePost(id);
    }

    @Override
    public void updatePost(int id, String NewTitle, String NewContent, String NewCategory) {

        DatabaseManager.updatePost(id,NewTitle,NewContent,NewCategory);
    }

    @Override
    public Post getPostById(int id) {
        return DatabaseManager.getPost(id);
    }

}
