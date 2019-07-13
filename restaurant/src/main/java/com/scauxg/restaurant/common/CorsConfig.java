/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/5/4 15:47
 * History:
 */
package com.scauxg.restaurant.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域访问配置
 *
 * @author Yue
 * @create 2019/5/4
 * @since 1.0.0
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        corsConfiguration.addExposedHeader("set-cookie");
        corsConfiguration.addExposedHeader("access-control-allow-headers");
        corsConfiguration.addExposedHeader("access-control-allow-methods");
        corsConfiguration.addExposedHeader("access-control-allow-origin");
        corsConfiguration.addExposedHeader("access-control-max-age");
        corsConfiguration.addExposedHeader("X-Frame-Options");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 配置接口跨域
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
