package com.dkm.resource;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.dkm.handle.ApplicationAdviceHandle;
import com.dkm.handle.GlobalResponseHandler;
import com.dkm.jwt.contain.LocalUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.dkm.resource.*.dao")
public class ResourceApplication extends SpringBootServletInitializer {

   public static void main(String[] args) {
      SpringApplication.run(ResourceApplication.class, args);
   }

   @Bean
   public GlobalResponseHandler getGlobalResponseHandler() {
      return new GlobalResponseHandler();
   }

   @Bean
   public ApplicationAdviceHandle getApplicationAdviceHandle() {
      return new ApplicationAdviceHandle();
   }

   /**
    * 多表分页的bean
    * @return
    */
   @Bean
   public PaginationInterceptor paginationInterceptor() {
      return new PaginationInterceptor();
   }

   @Bean
   public LocalUser getUser () {
      return new LocalUser();
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
