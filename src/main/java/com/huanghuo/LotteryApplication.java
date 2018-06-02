package com.huanghuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EnableCaching
@ComponentScan("com.huanghuo")
@MapperScan("com.huanghuo.wechatapp.mapper")
public class LotteryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LotteryApplication.class, args);
	}
}
