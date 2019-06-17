package com.github.hykes.ui.filter;

import com.github.hykes.util.TraceIdUtil;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-11 11:28:00
 */
@Activate(group = {Constants.CONSUMER, Constants.PROVIDER}, order = 99)
public class GlobalTraceFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = RpcContext.getContext().getAttachment("traceId");
        if ( !StringUtils.isEmpty(traceId) ) {
            // 从RpcContext里获取traceId并保存
            TraceIdUtil.setTraceId(traceId);
        } else {
            // 交互前重新设置traceId, 避免信息丢失
            RpcContext.getContext().setAttachment("traceId", TraceIdUtil.getTraceId());
        }
        // *) 实际的rpc调用
        return invoker.invoke(invocation);
    }

}