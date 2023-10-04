package com.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "aliyun.oss")
@Component
public class AliOSSProperties {
    private String endpoint;
    private String accessKey;
    private String accessSecret;
    private String bucketName;
}
