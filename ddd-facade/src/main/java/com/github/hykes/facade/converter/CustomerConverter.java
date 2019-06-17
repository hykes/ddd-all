package com.github.hykes.facade.converter;

import com.github.hykes.request.AbstractRequest;
import com.github.hykes.bean.request.CustomerPageRequest;
import com.github.hykes.bean.response.CustomerInfo;
import com.github.hykes.facade.domain.criteria.CustomerCriteria;
import com.github.hykes.facade.domain.model.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
public class CustomerConverter {

    public static CustomerCriteria get(CustomerPageRequest pageRequest) {

        CustomerCriteria criteria = new CustomerCriteria();
        BeanUtils.copyProperties(pageRequest, criteria);
        return criteria;
    }

    public static List<CustomerInfo> convertInfoList(Page<Customer> page) {
        List<CustomerInfo> list = new ArrayList();
        for (Customer domain : page.getContent()) {
            list.add(convertInfo(domain));
        }

        return list;
    }

    public static List<CustomerInfo> convertInfoList(List<Customer> list) {
        List<CustomerInfo> infoList = new ArrayList();
        for (Customer domain : list) {
            infoList.add(convertInfo(domain));
        }

        return infoList;
    }

    public static CustomerInfo convertInfo(Customer entity) {
        CustomerInfo info = new CustomerInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }

    public static Customer convertModel(AbstractRequest request) {
        Customer domain = new Customer();
        BeanUtils.copyProperties(request, domain);

        return domain;
    }

}
