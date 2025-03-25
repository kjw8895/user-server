package com.user.client.aws.s3.service;

import com.amazonaws.services.s3.model.S3Object;

import java.io.File;

public interface AwsS3Client {
    void putObject(String bucketName, String key, File file);
    S3Object getObject(String bucketName, String key);
}
