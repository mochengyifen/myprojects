package com.zhhong.mochen.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 董仁亮
 * @date 2020-01-13 16:30
 * @Description:日期类型转换器
 */
@Component
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        Date target = null;
        if (!StringUtils.isEmpty(source)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                target = format.parse(source);
            } catch (ParseException e) {
                throw new RuntimeException(String.format("parser %s to Date fail", source));
            }
        }
        return target;
    }

}
