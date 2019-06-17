package com.github.hykes.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:42:00
 */
@Getter
@Setter
@NoArgsConstructor
public class ApiExtInfo implements Serializable {

    private static final long serialVersionUID = -7684565099233424514L;

    /**
     * 租户编号
     */
    private Integer tenantId;

    /**
     * 额外信息
     */
    private Map<String, String> extra;

}
