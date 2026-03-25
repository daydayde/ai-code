package com.bobby.aicode.ai;

import com.bobby.aicode.ai.model.HtmlCodeResult;
import com.bobby.aicode.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.SystemMessage;
import reactor.core.publisher.Flux;

public interface AiCodeGeneratorService {
    /**
     * 生成单文件代码
     *
     * @param inputFile 用户提示词
     * @return AI的输出结果
     */
    @SystemMessage(fromResource = "prompt/htmlSystemPrompt.txt")
    HtmlCodeResult generateHTMLCode(String inputFile);

    /**
     * 生成多文件代码
     *
     * @param inputFile 用户提示词
     * @return AI的输出结果
     */
    @SystemMessage(fromResource = "prompt/multiFileSystemPrompt.txt")
    MultiFileCodeResult generateMultiFileCode(String inputFile);

    /**
     * 生成单文件代码
     *
     * @param inputFile 用户提示词
     * @return AI的输出结果
     */
    @SystemMessage(fromResource = "prompt/htmlSystemPrompt.txt")
    Flux<String> generateHTMLCodeStream(String inputFile);

    /**
     * 生成多文件代码
     *
     * @param inputFile 用户提示词
     * @return AI的输出结果
     */
    @SystemMessage(fromResource = "prompt/multiFileSystemPrompt.txt")
    Flux<String> generateMultiFileCodeStream(String inputFile);
}
