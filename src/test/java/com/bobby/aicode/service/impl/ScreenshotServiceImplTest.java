package com.bobby.aicode.service.impl;

import com.bobby.aicode.service.ScreenshotService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@Slf4j
class ScreenshotServiceImplTest {
    @Resource
    private ScreenshotService screenshotService;

    @Test
    void generateAndUploadScreenshot() {
        String testUrl = "https://www.qianwen.com";
        String webPageScreenshot = screenshotService.generateAndUploadScreenshot(testUrl);
        System.out.println(webPageScreenshot);
        Assertions.assertNotNull(webPageScreenshot);
    }
}