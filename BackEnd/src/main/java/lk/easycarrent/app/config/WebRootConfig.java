package lk.easycarrent.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 03
 **/

@Configuration
@Import(JPAconfig.class)
public class WebRootConfig {
}
