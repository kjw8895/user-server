package com.user.api.master.config;

import com.user.api.common.config.WebMvcConfig;
import com.user.client.redisson.config.RedissonConfig;
import com.user.core.config.UserCoreConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserCoreConfig.class, WebMvcConfig.class, RedissonConfig.class})
@ComponentScan(value = {
        "com.user.client.redisson",
        "com.user.api.common"
})
public class UserApiMasterConfig {
}
