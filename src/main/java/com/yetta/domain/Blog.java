package com.yetta.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
public class Blog {
    @Id
    private Long ranking;
    private Long yesterdayRanking;
    private String name;
    private Long subscriber;
    private Long totalContent;
    private Long monthlyAvgContent;
    private String tags;
    private String url;
    private LocalDate originDate;
    private String comment;
    private Integer totalScore;
    private Integer myScore;
    private Integer recordMyScore;
    private Integer recordNoContent;
    private Boolean newContent;

}
