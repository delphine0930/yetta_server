package com.yetta.controller;

import com.yetta.application.BlogService;
import com.yetta.controller.dto.BlogResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public List<BlogResponseDto> getBlogs(
            @RequestParam(required = false) String search
    ) {
        // 일단 100개로 고정
        List<BlogResponseDto> blogs = blogService.getBlogs(0, 100, search);

        return blogs;
    }
}
