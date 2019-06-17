package com.github.hykes.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * API分页请求 父类
 * - 继承 AbstractRequest
 * - 当前页码（默认1，从1开始）
 * - 每页条数（默认20，最大100）
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:23:00
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractPageRequest extends AbstractRequest {
    public static final int DEFAULT_PAGE_NO = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MIN_PAGE_SIZE = 1;
    public static final int MAX_PAGE_SIZE = 100;
    private static final long serialVersionUID = -3583130481377033176L;

    /**
     * 当前页码
     * - 默认1，从1开始
     */
    private int pageNo = DEFAULT_PAGE_NO;

    /**
     * 每页条数
     * - 默认20，最大100
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    @Override
    public void checkParam() {
        super.checkParam();

        if (pageNo < DEFAULT_PAGE_NO) {
            pageNo = DEFAULT_PAGE_NO;
        }

        if (pageSize < MIN_PAGE_SIZE) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
    }

}