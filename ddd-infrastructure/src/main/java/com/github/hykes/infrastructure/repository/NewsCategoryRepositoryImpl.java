package com.github.hykes.infrastructure.repository;

import com.github.hykes.domain.entity.NewsCategory;
import com.github.hykes.domain.repository.NewsCategoryRepository;

import java.util.Optional;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 16:04:00
 */
public class NewsCategoryRepositoryImpl implements NewsCategoryRepository {

    @Override
    public Optional<NewsCategory> getById(Long aLong) {
        return Optional.empty();
    }
}
