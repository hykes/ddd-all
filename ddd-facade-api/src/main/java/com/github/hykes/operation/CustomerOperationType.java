package com.github.hykes.operation;

import com.github.hykes.request.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Getter
@AllArgsConstructor
public enum CustomerOperationType implements OperationType {

    // 创建
    CREATE("创建", true),

    // 删除
    DELETE("删除", true),

    // 修改
    UPDATE("修改", true),

    // 分页
    PAGE("分页", false),

    // 查询
    FIND_BY_ID("查询", false);

    /**
     * 操作描述
     */
    private String description;

    /**
     * 是否写操作
     */
    private boolean write;

}
