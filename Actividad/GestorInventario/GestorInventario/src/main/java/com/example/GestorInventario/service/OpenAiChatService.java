package com.example.GestorInventario.service;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.data.message.UserMessage;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OpenAiChatService {

    private final ObjectProvider<ChatModel> chatModelProvider;

    public OpenAiChatService(ObjectProvider<ChatModel> chatModelProvider) {
        this.chatModelProvider = chatModelProvider;
    }

    public String ask(String message) {
        ChatModel model = chatModelProvider.getIfAvailable();
        if (model == null) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    "Configura openai.api-key en application-local.properties o OPENAI_API_KEY en el entorno");
        }

        ChatRequest request = ChatRequest.builder()
                .messages(UserMessage.from(message))
                .build();
        return model.chat(request).aiMessage().text();
    }
}
