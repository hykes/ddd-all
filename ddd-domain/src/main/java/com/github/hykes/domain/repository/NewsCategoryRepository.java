package com.github.hykes.domain.repository;

import com.github.hykes.domain.entity.NewsCategory;

import java.util.Optional;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 20:20:00
 */
public interface NewsCategoryRepository {

    Optional<NewsCategory> getById(Long aLong);

}
