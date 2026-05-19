package com.nurbol.car_marketplace.BeysenbayNurbolNotificationService;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class NotificationService {

    @Async
    public CompletableFuture<String> sendEmailNotification(
            String email
    ) {

        try {

            Thread.sleep(3000);

            System.out.println(
                    "Email sent to: " + email
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(
                "Notification sent"
        );
    }

    @Async
    public CompletableFuture<String> processImage(
            String imageName
    ) {

        try {

            Thread.sleep(2000);

            System.out.println(
                    "Image processed: " + imageName
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(
                "Image processed"
        );
    }
}