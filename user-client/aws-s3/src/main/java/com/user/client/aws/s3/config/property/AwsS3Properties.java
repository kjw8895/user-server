package com.user.client.aws.s3.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("aws.s3")
public class AwsS3Properties {
    private Credential credential;
    private String region;
    private S3 s3;

    public String fullPath() {
        return String.format("%s/%s", s3.bucket, s3.defaultFolder);
    }

    @Getter
    @Setter
    public static class Credential {
        private boolean enabled = true;
        private String accessKey;
        private String secretKey;
    }

    @Getter
    @Setter
    public static class S3 {
        private String bucket;
        private String defaultFolder;
    }
}
