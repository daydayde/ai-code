package com.bobby.aicode.langgraph4j.tools;

import com.bobby.aicode.langgraph4j.model.ImageResource;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.community.model.dashscope.WanxImageSize;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.output.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class LogoGeneratorTool {

    @Value("${dashscope.api-key}")
    private String dashScopeApiKey;

    @Value("${dashscope.image-model}")
    private String imageModel;

    @Tool("根据描述生成 Logo 设计图片，用于网站品牌标识")
    public Response<Image> generateLogos(@P("Logo 设计描述，如名称、行业、风格等，尽量详细") String description) {
        List<ImageResource> logoList = new ArrayList<>();
        try {
            // 构建 Logo 设计提示词
            String logoPrompt = String.format("生成 Logo，Logo 中禁止包含任何文字！Logo 介绍：%s", description);
            WanxImageModel wanxImageModel = WanxImageModel.builder()
                    .apiKey(dashScopeApiKey)
                    .modelName(imageModel)
                    .size(WanxImageSize.SIZE_1024_1024)
                    .build();
            Response<Image> result = wanxImageModel.generate(logoPrompt);
            return result;
//            if (result != null && result.getOutput() != null && result.getOutput().getResults() != null) {
//                List<Map<String, String>> results = result.getOutput().getResults();
//                for (Map<String, String> imageResult : results) {
//                    String imageUrl = imageResult.get("url");
//                    if (StrUtil.isNotBlank(imageUrl)) {
//                        logoList.add(ImageResource.builder()
//                                .category(ImageCategoryEnum.LOGO)
//                                .description(description)
//                                .url(imageUrl)
//                                .build());
//                    }
//                }
//            }
        } catch (Exception e) {
            log.error("生成 Logo 失败: {}", e.getMessage(), e);
        }
        return null;
    }
}
