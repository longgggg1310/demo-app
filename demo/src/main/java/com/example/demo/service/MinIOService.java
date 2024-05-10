package com.example.demo.service;

import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class MinIOService {
    private final MinioClient minioClient;
    private static final String BUCKET_NAME = "vdtdemoapp";
    private static final String END_POINT = "http://localhost:9000";

    public MinIOService() throws MinioException {
        // Kết nối tới MinIO
        this.minioClient  = MinioClient.builder()
                .endpoint("http://localhost:9000")
                .credentials("ARPsMUtFIie2iy776FiZ", "jcfUdzBai3TSdo5gFzCH2xF47ybTY7jjIpzYjDug")
                .build();
    }

    public List<String> getAllImageUrls() {
        List<String> imageUrls = new ArrayList<>();

        try {
            // Lấy danh sách các object trong bucket
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(BUCKET_NAME).recursive(true).build());

            // Lặp qua từng object và lấy đường dẫn URL
            for (Result<Item> result : results) {
                Item item = result.get();
                String objectName = item.objectName();
                String imageUrl = END_POINT + "/" + BUCKET_NAME + "/" + objectName;
                imageUrls.add(imageUrl);
            }
        } catch (MinioException | InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            // Xử lý ngoại lệ nếu cần
            e.printStackTrace();
        }

        return imageUrls;
    }

    

    
}
