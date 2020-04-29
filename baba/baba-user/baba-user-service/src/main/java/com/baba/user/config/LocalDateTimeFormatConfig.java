package com.baba.user.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * @author xiechao
 * @time 2019年3月16日 下午4:25:14
 * @version 1.0.0
 * @description 解决本地实体类属性LocalDateTime转到发给前端时时间格式为：2018-06-14T15:06:05 中间去不掉T的问题
 * 如果需要再个性化的时间方案，可参考：https://www.cnblogs.com/carrychan/p/9883172.html
 */
@Configuration
public class LocalDateTimeFormatConfig {

	@Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
	private String pattern;

	// 方案一
	@Bean
	public LocalDateTimeSerializer localDateTimeDeserializer() {
		return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
		return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeDeserializer());
	}

}
