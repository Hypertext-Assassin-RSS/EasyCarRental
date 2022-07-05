package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @PROJECT FileUploadSpring
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 04
 **/

@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {
}
