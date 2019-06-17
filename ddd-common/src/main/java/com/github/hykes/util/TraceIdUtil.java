package com.github.hykes.util;

import java.util.UUID;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-11 11:22:00
 */
public class TraceIdUtil {

    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal();

    public static String getTraceId() {
        if(TRACE_ID.get() == null) {
            String s = UUID.randomUUID().toString();
            setTraceId(s);
        }
        return TRACE_ID.get();
    }

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

}