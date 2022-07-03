package lk.easycarrent.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 03
 **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.easycarrent.app")
public class WebAppConfig {
}
