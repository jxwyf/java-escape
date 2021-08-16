package com.lhalj.spring.escape.date_se_de;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * 描述: 时间反序列化转换器
 */
@Slf4j
public class DateJacksonConverter extends JsonDeserializer<Date> {

    private static final String[] pottern = new String[]{
            "yyyy-MM-dd HH:mm:ss","yyyy/MM/dd"
    };


    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {

        Date targetDate = null;
        //获取时间字符串
        String originDate = jsonParser.getText();

        if(StringUtils.isNotEmpty(originDate)){

            try {
                long longDate = Long.parseLong(originDate.trim());
                targetDate = new Date(longDate);
            }catch (NumberFormatException pe){

                try{
                    targetDate = DateUtils.parseDate(originDate,DateJacksonConverter.pottern);
                }catch (ParseException exception){
                    log.error("parse error:{}",exception.getMessage());
                    throw new IOException("parse error");
                }
            }
        }
        return targetDate;
    }


    //需要反序列化的类型 标注起来 让jackson知道
    @Override
    public Class<?> handledType(){
        return Date.class;
    }
}
