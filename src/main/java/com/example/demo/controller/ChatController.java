package com.example.demo.controller;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import okhttp3.*;
@RestController
public class ChatController {
    private final String chatGPTAPIEndpoint = "https://api.openai.com/v1/engine/davinci-codex/completions";


    private String chatGPTAPIKey="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";

    @PostMapping("/chat")
    public Map<String, String> chatWithGPT(@RequestParam String userInput) throws Exception {
        Map<String, String> result = new HashMap<>();

        // ChatGPT API 호출
        String response = callChatGPTAPI(userInput);

        result.put("response", response);
        result.put("userInput", userInput);
        return result;
    }

    private String callChatGPTAPI(String userInput) throws Exception {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\": \"" + userInput + "\",\"max_tokens\":1000,\"temperature\":0.5}");

        Request request = new Request.Builder()
                .url(chatGPTAPIEndpoint)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + chatGPTAPIKey)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}