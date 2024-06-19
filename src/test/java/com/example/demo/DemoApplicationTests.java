package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void postNoArg() {
        Post post = new Post();
        assertNotNull(post);
    }

    @Test
    void postConstructorTest() {
        Post post = new Post(1, "Test Title", "Test Content", "Test Category");
        assertEquals(1, post.getId());
        assertEquals("Test Title", post.getTitle());
        assertEquals("Test Content", post.getContent());
        assertEquals("Test Category", post.getCategory());
    }

    @Test
    void postOneArg() {
        Post post = new Post("Test Title", "Test Content", "Test Category");
        assertEquals("Test Title", post.getTitle());
        assertEquals("Test Content", post.getContent());
        assertEquals("Test Category", post.getCategory());
    }

    @Test
    void postGetsSets() {
        Post post = new Post();
        post.setId(1);
        post.setTitle("Test Title");
        post.setContent("Test Content");
        post.setCategory("Test Category");

        assertEquals(1, post.getId());
        assertEquals("Test Title", post.getTitle());
        assertEquals("Test Content", post.getContent());
        assertEquals("Test Category", post.getCategory());
    }
}
