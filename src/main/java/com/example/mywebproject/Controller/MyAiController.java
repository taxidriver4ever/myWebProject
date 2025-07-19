package com.example.mywebproject.Controller;


import com.example.mywebproject.Pojo.AiRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
public class MyAiController {

    @Autowired
    private ChatClient chatClient;

    @PostMapping(value = "/ai/chat",produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestBody AiRequest request) {
        return chatClient
                .prompt()
                .user(request.getPrompt())
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, request.getConversationId()))
                .stream()
                .content();
    }
}
