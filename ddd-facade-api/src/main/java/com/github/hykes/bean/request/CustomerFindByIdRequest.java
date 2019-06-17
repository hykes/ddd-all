package com.github.hykes.bean.request;

import com.github.hykes.request.AbstractRequest;
import com.github.hykes.request.OperationType;
import com.github.hykes.operation.CustomerOperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:39:55
 * @generate by CodeGen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFindByIdRequest extends AbstractRequest {

    private Long id;

    @Override
    public OperationType getOperationType() {
        return CustomerOperationType.FIND_BY_ID;
    }

    @Override
    public void checkParam() {
        super.checkParam();
    }
}
