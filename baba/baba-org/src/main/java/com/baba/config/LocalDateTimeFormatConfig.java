package com.baba.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author xiechao
 * @time 2019年3月16日 下午4:25:14
 * @version 1.0.0
 * @description 
 * 1.解决如@RequestBody(required=true) CustomerTagGroupModel model这样的model中定义有LocalDateTime类，前端传String进来，LocalDateTime报错的问题
 * https://blog.csdn.net/WeiHao0240/article/details/100739760 采用这个方案不仅解决前端传参对应到LocalDateTime属性的问题，后台接口返回给前端时时间格式应该是在application.yml文件中配置的，如
 * jackson:
    date-format: yyyy-MM-dd HH:mm:ss
 * 2.解决本地实体类属性LocalDateTime转到发给前端时时间格式为：2018-06-14T15:06:05 中间去不掉T的问题
 * 如果需要再个性化的时间方案，可参考：https://www.cnblogs.com/carrychan/p/9883172.html
 */
@Configuration
public class LocalDateTimeFormatConfig {

//	@Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
//	private String pattern;
//
//	// 方案一
//	@Bean
//	public LocalDateTimeSerializer localDateTimeDeserializer() {
//		return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
//	}
//
//	@Bean
//	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//		return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
//	}
	
	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * string转localdate
     */
    @Bean
    public Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                if (source.trim().length() == 0)
                    return null;
                try {
                    return LocalDate.parse(source);
                } catch (Exception e) {
                    return LocalDate.parse(source, DateTimeFormatter.ofPattern(DATE_PATTERN));
                }
            }
        };
    }

    /**
     * string转localdatetime
     */
    @Bean
    public Converter<String, LocalDateTime> localDateTimeConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                if (source.trim().length() == 0)
                    return null;
                // 先尝试ISO格式: 2019-07-15T16:00:00
                try {
                    return LocalDateTime.parse(source);
                } catch (Exception e) {
                    return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
                }
            }
        };
    }

    /**
     * 统一配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        JavaTimeModule module = new JavaTimeModule();
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        return builder -> {
            builder.simpleDateFormat(DATE_TIME_PATTERN);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
            builder.modules(module);
        };
    }


}
