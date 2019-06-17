package com.github.hykes.domain.repository;


import com.github.hykes.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 10:53:00
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    List<Customer> findByLastName(String lastName);
}