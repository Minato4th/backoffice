package com.event.backoffice.configuration;

import com.event.backoffice.BackOfficeApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class SpringBootServlet extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BackOfficeApplication.class);
    }
}

