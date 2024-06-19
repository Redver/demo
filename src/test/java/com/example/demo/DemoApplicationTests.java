package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void PostNoArg()
    {
        Post post = new Post();
        assertNotNull(post)
    }

    @Test 
    void PostConstructorTest
    {
        Post post = new Post(1,"Test Title", "Test Content", "Test Category");
        assertEquals(1, post.getId());
        assertEquals("Test Title", post.getTitle());
        assertEquals("Test Content", post.getContent());
        assertEquals("Test Category", post.getCategory());
    }

    @Test
    void PostOneArg()
    {
        Post post = new Post("Test Title");
        assertEquals("Test Title", post.getTitle());
    }

    @Test
    void PostGetsSets() {
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
