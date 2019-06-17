package com.github.hykes.facade;

import com.github.hykes.response.Response;
import com.github.hykes.bean.request.CustomerCreateRequest;
import com.github.hykes.bean.request.CustomerUpdateRequest;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
public interface CustomerWriterFacade {

    /**
     * 创建客户
     */
    Response<Long> create(CustomerCreateRequest request);

    /**
     * 更新客户
     */
    Response<Boolean> update(CustomerUpdateRequest request);

}
