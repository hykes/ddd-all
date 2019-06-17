package com.github.hykes.domain.shared;

import java.io.Serializable;

/**
 * 实体接口类
 * @author hehaiyangwork@gmail.com
 * @date 2019-03-01 11:32:00
 */
public interface Entity<T> extends Serializable {

  /**
   * Entities compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardless of other attributes.
   */
  boolean sameIdentityAs(T other);

}
