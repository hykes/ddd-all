package com.github.hykes.facade.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_customer")
public class Customer {

    private static final long serialVersionUID = -3411544651937688829L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT(20) NOT NULL")
    private Long id;

    @Column(name = "first_name", columnDefinition = "varchar NOT NULL COMMENT '姓'")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar NOT NULL COMMENT '名'")
    private String lastName;

    @Column(name = "status", columnDefinition = "tinyint NOT NULL COMMENT '状态'")
    private Integer status;

    @Column(name = "version", columnDefinition = "int NOT NULL COMMENT '版本号'")
    private Integer version;

    @Column(name = "is_deleted", columnDefinition = "tinyint NOT NULL COMMENT '是否删除'")
    private Integer isDeleted;

    @Column(name = "extra_json", columnDefinition = "varchar NOT NULL COMMENT '扩展信息'")
    private String extraJson;

    @Column(name = "created_at", columnDefinition = "DATETIME NOT NULL COMMENT '创建时间'")
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME NOT NULL COMMENT '更新时间'")
    private Date updatedAt;

}
