package com.yetta.application;

import com.yetta.controller.dto.BlogResponseDto;
import com.yetta.domain.Blog;
import com.yetta.domain.BlogRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogResponseDto> getBlogs(int pageNo, int pageSize, String search) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        List<BlogResponseDto> blogs = blogRepository.search(search, paging);

        return blogs;
    }

}
