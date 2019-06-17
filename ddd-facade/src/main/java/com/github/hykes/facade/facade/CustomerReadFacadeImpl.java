package com.github.hykes.facade.facade;

import com.github.hykes.bean.request.CustomerFindByIdRequest;
import com.github.hykes.bean.request.CustomerPageRequest;
import com.github.hykes.bean.response.CustomerInfo;
import com.github.hykes.facade.CustomerReadFacade;
import com.github.hykes.facade.converter.CustomerConverter;
import com.github.hykes.facade.domain.criteria.CustomerCriteria;
import com.github.hykes.facade.domain.model.Customer;
import com.github.hykes.facade.server.repository.CustomerRepository;
import com.github.hykes.response.Paging;
import com.github.hykes.response.Response;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Service(version = "1.0.0")
public class CustomerReadFacadeImpl implements CustomerReadFacade {

    private final CustomerRepository customerRepository;

    public CustomerReadFacadeImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Response<CustomerInfo> findById(CustomerFindByIdRequest request) {
        Optional<Customer> op = customerRepository.findById(request.getId());
        if (!op.isPresent()) {
            return Response.ok();
        }
        return Response.ok(transToInfo(op.get()));
    }

    @Override
    public Response<Paging<CustomerInfo>> paging(CustomerPageRequest request) {
        CustomerCriteria criteria = CustomerConverter.get(request);
        Page<Customer> page = customerRepository.findAll(criteria.getSpecification(), criteria.getPageRequest());
        return Response.ok(transToInfo(page));
    }


    private Paging<CustomerInfo> transToInfo(Page<Customer> page) {
        List<Customer> list = page.getContent();
        List<CustomerInfo> infoList = list.stream().map(this::transToInfo).collect(Collectors.toList());
        return new Paging<>(page.getTotalElements(), infoList);
    }

    private CustomerInfo transToInfo(Customer equity) {
        CustomerInfo info = CustomerConverter.convertInfo(equity);
        return info;
    }
}
