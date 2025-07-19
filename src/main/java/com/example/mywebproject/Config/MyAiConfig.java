package com.example.mywebproject.Config;

import jakarta.mail.Message;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAiConfig {

    @Bean
    public ChatClient chatClient(OllamaChatModel model) {
        MessageWindowChatMemory build = MessageWindowChatMemory.builder().build();

        return ChatClient
                .builder(model)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(build).build())
                .build();
    }
}
