package com.example.demo.DataAccess;

import com.example.demo.Model.Post;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DatabaseManager {
    private static boolean first = true;

    private static Connection getConnection() throws SQLException
    {
        if (first)
        {
            DatabaseSetup.start();
            first = false;
        }
        return DriverManager.getConnection("jdbc:postgresql://database:5432/postgres?currentSchema=assignment","postgres","postgres");
    }

    public static void MakePost(String title, String content, String category) {
        String sql = "INSERT INTO posts (title, content, category) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, category);
            pstmt.executeUpdate();
            System.out.println("Post inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting post: " + e.getMessage());
        }
    }

    public static List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String category = rs.getString("category");
                Post post = new Post(id, title, content, category);
                posts.add(post);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all posts: " + e.getMessage());
        }
        return posts;
    }

    public static void deletePost(int id) {
        String sql = "DELETE FROM posts WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Post with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No post found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting post: " + e.getMessage());
        }
    }

    public static void updatePost(int id, String newTitle, String newContent, String newCategory) {
        String sql = "UPDATE posts SET title = ?, content = ?, category = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newContent);
            pstmt.setString(3, newCategory);
            pstmt.setInt(4, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Post with ID " + id + " updated successfully.");
            } else {
                System.out.println("No post found with ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("Error updating post: " + e.getMessage());
        }
    }

    public static Post getPost(int id)
    {
        String sql = "SELECT * FROM POSTS WHERE Id = ?";
        Post postGot = new Post();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int TempId = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String category = rs.getString("category");
                postGot = new Post(TempId, title, content, category);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all posts: " + e.getMessage());
        }
        return postGot;

    }
}


