package com.yetta.controller.dto;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Getter
public class BlogResponseDto {
    private Long ranking;
    private Long yesterdayRanking;
    private String name;
    private Long subscriber;
    private Long totalContent;
    private Long monthlyAvgContent;
    private List<String> tags;
    private String url;
    private String newContent;
    private String comment;

    public BlogResponseDto(Long ranking, Long yesterdayRanking,
                           String name, Long subscriber,
                           Long totalContent, Long monthlyAvgContent,
                           String tags, String url,
                           String newContent, String comment) {
        this.ranking = ranking;
        this.yesterdayRanking = yesterdayRanking;
        this.name = name;
        this.subscriber = subscriber;
        this.totalContent = totalContent;
        this.monthlyAvgContent = monthlyAvgContent;
        this.tags = Arrays.asList(tags.split(","));
        this.url = url;
        this.newContent = StringUtils.hasText(newContent) ? newContent : "FALSE";
        this.comment = comment;
    }

}
