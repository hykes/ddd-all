package com.github.hykes.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-05-10 14:59:00
 */
public abstract class Criteria {

    protected static final ObjectMapper MAPPER = new ObjectMapper();
    static{
        //设置输出时包含属性的风格
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        //设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //注册guava类型
        MAPPER.registerModule(new GuavaModule());
        //规范化日期类型
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> toMap(){
        return MAPPER.convertValue(this, Map.class);
    }
}
