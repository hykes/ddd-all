package com.github.hykes.domain.entity;

import com.github.hykes.domain.shared.AbstractEntity;
import com.github.hykes.domain.valueobject.NewsCategoryStatus;
import lombok.Data;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 14:43:00
 */
@Data
public class NewsCategory extends AbstractEntity<Long, NewsCategory> {

    private static final long serialVersionUID = -985020161911892393L;

    private String name;

    private NewsCategoryStatus status;

    /**
     * 启用
     */
    public void enable(){
        setStatus(NewsCategoryStatus.ENABLE);
    }

    /**
     * 禁用
     */
    public void disable(){
        setStatus(NewsCategoryStatus.DISABLE);
    }

    /**
     * 初始化，默认状态位 ENABLE
     */
    private void init() {
        setStatus(NewsCategoryStatus.ENABLE);
    }

    @Override
    public boolean sameIdentityAs(NewsCategory other) {
        return other != null && this.getId().equals(other.getId());
    }

}
