package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
  /**
   * OpenFeign重试策略
   * @return
   */
  @Bean
  public Retryer retryer() {
    return Retryer.NEVER_RETRY; // 默认关闭重试
//    return new Retryer.Default(100, 1, 3); // 开启重试策略
  }

  /**
   * 开启OpenFeign日志功能
   * @return
   */
  @Bean
  public Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
