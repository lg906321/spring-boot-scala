package com.github.ryze;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.scala.DefaultScalaModule;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * 服务器配置
 */
@Configuration
public class ServerConfiguration
{
  @Bean
  public ObjectMapper mapper()
  {
    final ObjectMapper mapper = new ObjectMapper();
    //注册Scala模型
    mapper.registerModule(new DefaultScalaModule());
    //驼峰转下划线
    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    //格式化输出
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    //禁用日期时间戳
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    //忽略实体没有的字段
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    //不输出null,"",空字段
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    //日期格式化
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    return mapper;
  }

  /**
   * JSON解析用Jackson 别用FastJSON了，太老了。
   */
  @Bean
  public HttpMessageConverters jsonHttpMessageConverters(final ObjectMapper mapper)
  {
    return new HttpMessageConverters(new MappingJackson2HttpMessageConverter(mapper));
  }
}
