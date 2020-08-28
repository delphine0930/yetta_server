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
    private Long _01yesterdayRanking;
    private String _02name;
    private Long _03subscriber;
    private Long _04totalContent;
    private Long _05monthlyAvgContent;
    private String _06tags;
    private String _07url;
    private LocalDate _08originDate;
    private String _09comment;
    private Integer _10totalScore;
    private Integer _11myScore;
    private Integer _12recordMyScore;
    private Integer _13recordNoContent;
    private Boolean _14newContent;

}
