package com.github.hykes.bean.response;

import com.github.hykes.response.ApiExtInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfo extends ApiExtInfo {

    private static final long serialVersionUID = -7222837951420580151L;

    private Long id;

    private String firstName;

    private String lastName;

    private Integer status;

    private Integer version;

    private Integer isDeleted;

    private Date createdAt;

    private Date updatedAt;

}
