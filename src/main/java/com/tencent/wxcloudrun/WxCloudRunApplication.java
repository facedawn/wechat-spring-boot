package com.tencent.wxcloudrun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"com.tencent.wxcloudrun.*"})
@EnableConfigurationProperties
@MapperScan(basePackages = {"com.tencent.wxcloudrun.dao","com.tencent.wxcloudrun.mapper"})
public class WxCloudRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}
