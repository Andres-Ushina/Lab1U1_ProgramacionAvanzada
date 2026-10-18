package com.example.GestorInventario.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(@NotBlank(message = "El mensaje no puede estar vacío") String message) {
}
