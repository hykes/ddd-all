package com.github.hykes.facade.facade;

import com.github.hykes.bean.request.CustomerCreateRequest;
import com.github.hykes.bean.request.CustomerUpdateRequest;
import com.github.hykes.facade.CustomerWriterFacade;
import com.github.hykes.facade.converter.CustomerConverter;
import com.github.hykes.facade.domain.model.Customer;
import com.github.hykes.facade.server.repository.CustomerRepository;
import com.github.hykes.response.Response;
import com.github.hykes.util.JpaUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Service(version = "1.0.0")
public class CustomerWriteFacadeImpl implements CustomerWriterFacade {

    private final CustomerRepository customerRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    public CustomerWriteFacadeImpl(CustomerRepository customerRepository,
                                   EntityManager entityManager) {
        this.customerRepository = customerRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Response<Long> create(CustomerCreateRequest request) {
        Customer po = CustomerConverter.convertModel(request);
        po.setCreatedAt(new Date());
        po.setUpdatedAt(new Date());
        customerRepository.save(po);
        return Response.ok(po.getId());
    }

    @Override
    public Response<Boolean> update(CustomerUpdateRequest request) {
        Customer model = CustomerConverter.convertModel(request);
        model.setUpdatedAt(new Date());

        Customer target = entityManager.find(Customer.class, request.getId());

        BeanUtils.copyProperties(model, target, JpaUtil.getNullPropertyNames(model));

        customerRepository.save(target);
        return Response.ok(true);
    }

}
