package com.github.hykes.facade.domain.criteria;

import com.github.hykes.request.PagingCriteria;
import com.github.hykes.facade.domain.model.Customer;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCriteria extends PagingCriteria {

    private static final long serialVersionUID = -7222837951420580151L;

    private Long id;

    private String firstName;

    private String lastName;

    private Integer status;

    private Integer version;

    private Integer isDeleted;

    private String extraJson;

    public Specification<Customer> getSpecification() {
        return new Specification<Customer>() {

            private static final long serialVersionUID = 2299404518563972609L;
            List<Predicate> predicateList = Lists.newArrayList();

            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {

                if (Objects.nonNull(id)) {
                    predicateList.add(cb.equal(root.get("id").as(Long.class), id));
                }

                Predicate[] pre = new Predicate[predicateList.size()];
                return query.where(predicateList.toArray(pre)).getRestriction();
            }
        };
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(pageNo - 1, pageSize);
    }

}
