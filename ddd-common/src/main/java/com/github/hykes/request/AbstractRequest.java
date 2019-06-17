package com.github.hykes.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * API 请求 父类
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:21:00
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 1262647705056189635L;

    /**
     * 请求编号
     * - 日志全流程跟踪UUID
     */
    private String traceId;

    /**
     * 接口直接调用者IP地址
     */
    private String sourceIp;

    /**
     * 接口直接调用者类型
     */
    private String callerType;

    /**
     * 租户编号
     */
    private Integer tenantId;

    /**
     * 额外信息
     */
    private Map<String, String> extra;

    /**
     * 操作类型
     * - 由子类声明自己的操作类型
     *
     * @return 请求对应的操作类型
     */
    public abstract OperationType getOperationType();

    /**
     * 入参校验
     * - 校验失败时，统一返回 IllegalArgumentException 异常
     */
    public void checkParam() {

    }
}
