package com.dkm.resource;


import com.dkm.aop.beans.Aspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qf
 */
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.dkm.resource.*.dao")
public class ResourceApplication extends Aspect {

   public static void main(String[] args) {
      SpringApplication.run(ResourceApplication.class, args);
   }

   /**
    * 打包
    * @param builder
    * @return
    */
   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(ResourceApplication.class);
   }

}
