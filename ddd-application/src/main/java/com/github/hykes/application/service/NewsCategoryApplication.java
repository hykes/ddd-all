package com.github.hykes.application.service;

import com.github.hykes.domain.entity.NewsCategory;


/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 20:23:00
 */
public interface NewsCategoryApplication {

    Integer create(NewsCategory creator);

    void update(NewsCategory updater);

    void enable(Long id);

    void disable(Long id);

    NewsCategory getById(Long aLong);

}
