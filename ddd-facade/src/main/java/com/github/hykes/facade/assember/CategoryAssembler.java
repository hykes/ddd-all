package com.github.hykes.facade.assember;

import com.github.hykes.domain.entity.NewsCategory;
import com.github.hykes.facade.dto.NewsCategoryDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-03-01 10:56:00
 */
public class CategoryAssembler {

    public static NewsCategory toEntity(NewsCategoryDTO newsCategoryDTO) {
        if (newsCategoryDTO == null) {
            return null;
        }
        NewsCategory result = new NewsCategory();
        result.setName(newsCategoryDTO.getName());
        return result;
    }

    public static List<NewsCategory> toEntitys(Collection<NewsCategoryDTO> newsCategoryDTOs) {
        if (newsCategoryDTOs == null) {
            return null;
        }
        List<NewsCategory> results = new ArrayList<NewsCategory>();
        for (NewsCategoryDTO each : newsCategoryDTOs) {
            results.add(CategoryAssembler.toEntity(each));
        }
        return results;
    }

    public static NewsCategoryDTO toDTO(NewsCategory newsCategory) {
        if (newsCategory == null) {
            return null;
        }
        NewsCategoryDTO result = new NewsCategoryDTO();
        result.setName(newsCategory.getName());
        return result;
    }

    public static List<NewsCategoryDTO> toDTOs(Collection<NewsCategory> newsCategorys) {
        if (newsCategorys == null) {
            return null;
        }
        List<NewsCategoryDTO> results = new ArrayList<NewsCategoryDTO>();
        for (NewsCategory each : newsCategorys) {
            results.add(CategoryAssembler.toDTO(each));
        }
        return results;
    }
    
}
