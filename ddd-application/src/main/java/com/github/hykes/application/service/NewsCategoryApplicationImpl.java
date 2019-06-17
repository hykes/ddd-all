package com.github.hykes.application.service;

import com.github.hykes.domain.entity.NewsCategory;
import com.github.hykes.domain.repository.NewsCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 20:25:00
 */
public class NewsCategoryApplicationImpl implements NewsCategoryApplication {

//    @Autowired
    private NewsCategoryRepository newsCategoryRepository;

    protected NewsCategoryRepository getNewsCategoryRepository() {
        return this.newsCategoryRepository;
    }

    protected <T> List<T> convertNewsCategoryList(List<NewsCategory> src,
                                                  Function<NewsCategory, T> converter) {
//        if (CollectionUtils.isEmpty(src)) {
//            return Collections.emptyList();
//        }
        return src.stream().map(converter).collect(Collectors.toList());
    }

    @Override
    public Integer create(NewsCategory creator) {
//        this.getNewsCategoryRepository().getById(creator.getId());
        return Integer.valueOf(1);
    }

    @Override
    public void update(NewsCategory updater) {
        NewsCategory result = this.getNewsCategoryRepository().getById(updater.getId()).get();
        result.setName(updater.getName());
        // dao
    }

    @Override
    public void enable(Long id) {
        NewsCategory result = this.getNewsCategoryRepository().getById(id).get();
        result.enable();
    }

    @Override
    public void disable(Long id) {
        NewsCategory result = this.getNewsCategoryRepository().getById(id).get();
        result.disable();
    }

    @Override
    public NewsCategory getById(Long aLong) {
        Optional<NewsCategory> result = this.getNewsCategoryRepository().getById(aLong);
        return result.get();
    }

}
