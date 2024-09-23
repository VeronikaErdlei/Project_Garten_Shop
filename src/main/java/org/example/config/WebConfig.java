  package org.example.config;

  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.core.convert.ConversionService;
  import org.springframework.format.support.DefaultFormattingConversionService;
  import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

  @Configuration
public class WebConfig {
    @Bean
    public ConversionService mvcConversionService() {
        return new DefaultFormattingConversionService();
    }
    @Bean
    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
        return new HandlerMappingIntrospector();

    }


}



