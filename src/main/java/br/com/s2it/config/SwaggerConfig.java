package br.com.s2it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {  
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
		  .apiInfo(new ApiInfo("test-s2it", "API Documentation to support services provided by S2it.", 
      		  "1.0.0-SNAPSHOT", "http://www.s2it.com.br", new Contact("Fúlvio Falcão", "", "fulviofalcao@gmail.com"), 
      		  "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0")) 
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.com.s2it.resource"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
}
