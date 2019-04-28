package org.rxjava.common.core.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author happy 2019-04-27 11:06
 */
public class PageAgent<T> {
    private ReactiveMongoTemplate reactiveMongoTemplate;
    private Class<T> clazz;

    public PageAgent(ReactiveMongoTemplate reactiveMongoTemplate, Class<T> clazz) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.clazz = clazz;
    }

    public Mono<Page<T>> findPage(Query query, Pageable pageable) {
        return Mono
                .zip(
                        reactiveMongoTemplate.find(query, clazz).collectList(),
                        reactiveMongoTemplate.count(query, clazz)
                )
                .map(z -> {
                    List<T> goodsList = z.getT1();
                    Long num = z.getT2();
                    return new PageImpl<>(goodsList, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), num);
                });
    }
}
