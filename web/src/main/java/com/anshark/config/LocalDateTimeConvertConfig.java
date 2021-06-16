package com.anshark.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/6 18:13
 */
@Slf4j
@Configuration
public class LocalDateTimeConvertConfig {

    @Bean
    public LocalDateTimeSerializer localDateTimeDeserializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
    }

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = null;
                try {
                    //2020-01-01 00:00:00
                    switch (source.length()){
                        case 10:
                            log.info("传过来的是日期格式：{}",source);
                            source=source+" 00:00:00";
                            break;
                        case 13:
                            log.info("传过来的是日期 小时格式：{}",source);
                            source=source+":00:00";
                            break;
                        case 16:
                            log.info("传过来的是日期 小时:分钟格式：{}",source);
                            source=source+":00";
                            break;
                    }
                    dateTime = LocalDateTime.parse(source, df);
                } catch (Exception e) {
                    log.error(e.getMessage(),e);
                    e.printStackTrace();
                }
                return dateTime;
            }
        };
    }
}
