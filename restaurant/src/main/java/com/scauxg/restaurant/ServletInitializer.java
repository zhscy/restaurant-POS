/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/26 15:15
 * History:
 */
package com.scauxg.restaurant;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 部署启动类
 *
 * @author Yue
 * @create 2019/3/26
 * @since 1.0.0
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestaurantApplication.class);
    }
}
