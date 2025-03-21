package com.user.api.master.config;

import com.user.api.common.config.WebMvcConfig;
import com.user.core.config.UserCoreConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({UserCoreConfig.class, WebMvcConfig.class})
public class UserApiMasterConfig {
}
