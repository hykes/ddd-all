package com.github.hykes.domain.shared;

import lombok.Data;

/**
 * 实体抽象类
 * @author hehaiyangwork@gmail.com
 * @date 2019-03-01 11:32:00
 */
@Data
public abstract class AbstractEntity<K, T> implements Entity<T> {

    /**
     * 实体ID
     */
    private K id;

    /**
     * 版本号，用于乐观锁
     * 不使用Integer，因为Integer的默认值为null，而int的默认值为0
     */
    private int version;

}
