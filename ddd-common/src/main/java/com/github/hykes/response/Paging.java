package com.github.hykes.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:45:00
 */
@Data
public class Paging<T> implements Serializable {

    private static final long serialVersionUID = 755183539178076901L;

    private Long total;

    private List<T> data;

    public Paging() {
    }

    public Paging(Long total, List<T> data) {
        this.data = data;
        this.total = total;
    }

    public Boolean isEmpty() {
        return Objects.equals(0L, total) || data == null || data.isEmpty();
    }

    @SuppressWarnings("all")
    public static <T> Paging<T> empty(Class<T> clazz) {
        List<T> emptyList = Collections.emptyList();
        return new Paging<T>(0L, emptyList);
    }

    public static <T> Paging<T> empty() {
        return new Paging(0L, Collections.<T>emptyList());
    }

}
