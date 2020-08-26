package com.yetta.domain;

import com.yetta.controller.dto.BlogResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogSearchRepository {
    List<BlogResponseDto> search(String input, Pageable pageable);
}
