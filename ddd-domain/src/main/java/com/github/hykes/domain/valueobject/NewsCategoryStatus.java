package com.github.hykes.domain.valueobject;

import com.github.hykes.domain.shared.ValueObject;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 14:49:00
 */
public enum  NewsCategoryStatus implements ValueObject<NewsCategoryStatus> {

    //
    ENABLE(1),

    //
    DISABLE(0);

    private final int code;

    NewsCategoryStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean sameValueAs(NewsCategoryStatus other) {
        return this.equals(other);
    }

}
