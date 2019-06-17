package com.github.hykes.request;

/**
 * 各API服务端定义自己的接口操作类型枚举值
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:22:00
 */
public interface OperationType {

    /**
     * 操作类型名称
     *
     * @return 操作类型名称
     */
    String name();

    /**
     * 操作类型简述
     *
     * @return 操作类型简述
     */
    String getDescription();

    /**
     * 是否为写操作
     *
     * @return true-是，false-否
     */
    boolean isWrite();

}