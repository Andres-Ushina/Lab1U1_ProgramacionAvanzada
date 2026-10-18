package com.example.GestorInventario.controller;

import com.example.GestorInventario.dto.ChatRequest;
import com.example.GestorInventario.dto.ChatResponse;
import com.example.GestorInventario.service.OpenAiChatService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class ChatController {

    private final OpenAiChatService chatService;

    public ChatController(OpenAiChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@Valid @RequestBody ChatRequest request) {
        return new ChatResponse(chatService.ask(request.message()));
    }
}
