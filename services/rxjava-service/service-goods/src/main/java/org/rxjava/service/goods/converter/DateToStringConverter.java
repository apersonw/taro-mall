package org.rxjava.service.goods.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author happy 2019-04-07 15:28
 */
public class DateToStringConverter implements Converter<Date,String> {
    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private String format;

    public DateToStringConverter() {
        this(FORMAT_PATTERN);
    }

    public DateToStringConverter(String format) {
        this.format = format;
    }

    @Override
    public String convert(Date source) {
        if (source == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat.format(source);
    }
}
