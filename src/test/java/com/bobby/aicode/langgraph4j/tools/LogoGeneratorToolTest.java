package com.bobby.aicode.langgraph4j.tools;

import cn.hutool.json.JSONUtil;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.output.Response;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogoGeneratorToolTest {
    @Resource
    private LogoGeneratorTool logoGeneratorTool;

    @Test
    void generateLogos() {
        Response<Image> logo = logoGeneratorTool.generateLogos("一个个人博客的logo");
        String jsonPrettyStr = JSONUtil.toJsonPrettyStr(logo);
        System.out.println(jsonPrettyStr);

    }
}