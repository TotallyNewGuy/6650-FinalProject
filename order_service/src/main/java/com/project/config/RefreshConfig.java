package com.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class RefreshConfig {

    @Value("${version}")
    private String version;

    public String getVersion() {
        return version;
    }
}

