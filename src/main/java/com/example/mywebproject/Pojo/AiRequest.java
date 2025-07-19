package com.example.mywebproject.Pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AiRequest {
    private String prompt;
    private String conversationId;
}
