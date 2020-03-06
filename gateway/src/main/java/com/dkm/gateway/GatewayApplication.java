package com.dkm.gateway;

import com.dkm.aop.beans.GatewayAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author qf
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class GatewayApplication extends GatewayAspect {

   public static void main(String[] args) {
      SpringApplication.run(GatewayApplication.class, args);
   }

   /**
    * 打包
    * @param builder
    * @return
    */
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(GatewayApplication.class);
   }

}
