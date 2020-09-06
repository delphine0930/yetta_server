package com.yetta.domain;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yetta.controller.dto.BlogResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.yetta.domain.QBlog.*;

public class BlogRepositoryImpl implements BlogSearchRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BlogRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<BlogResponseDto> search(String input, Pageable pageable) {

        return jpaQueryFactory
                .select(Projections.constructor(BlogResponseDto.class,
                        blog.ranking,
                        blog._01yesterdayRanking,
                        blog._02name,
                        blog._03subscriber,
                        blog._04totalContent,
                        blog._05monthlyAvgContent,
                        blog._06tags,
                        blog._07url,
                        blog._14newContent,
                        blog._09comment))
                .from(blog)
                .where(
                        searchAll(input),
                        topN(100) // 상위 100개 고정
                )
                .orderBy(blog.ranking.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


    private BooleanExpression searchAll(String input) {
        return StringUtils.hasText(input) ? tagContains(input).or(nameContains(input)) : null;
    }

    private BooleanExpression topN(Integer n) {
        return n == null ? null : blog.ranking.loe(n);
    }

    private BooleanExpression tagContains(String input) {
        return StringUtils.hasText(input) ? blog._06tags.contains(input) : null;
    }

    private BooleanExpression nameContains(String input) {
        return StringUtils.hasText(input) ? blog._02name.contains(input) : null;
    }
}
