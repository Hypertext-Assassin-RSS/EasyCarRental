package app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @PROJECT FileUploadSpring
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 04
 **/

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "app")
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
