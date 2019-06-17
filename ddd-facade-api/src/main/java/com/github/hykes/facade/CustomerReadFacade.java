package com.github.hykes.facade;

import com.github.hykes.response.Paging;
import com.github.hykes.response.Response;
import com.github.hykes.bean.request.CustomerFindByIdRequest;
import com.github.hykes.bean.request.CustomerPageRequest;
import com.github.hykes.bean.response.CustomerInfo;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
public interface CustomerReadFacade {

    /**
     * 查询客户
     */
    Response<CustomerInfo> findById(CustomerFindByIdRequest id);

    /**
     * 分页查询客户
     */
    Response<Paging<CustomerInfo>> paging(CustomerPageRequest pageRequest);

}
