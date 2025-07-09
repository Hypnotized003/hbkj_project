package org.hbkj.springbootmybatis.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文档配置类，用于生成文档
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("LXZ的超市管理系统")
                        .description("生产实训演示项目API地址")
                        .version("1.0")
                        .termsOfService("http://goods")
                );
    }
}