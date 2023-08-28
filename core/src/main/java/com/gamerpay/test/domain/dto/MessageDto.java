package com.gamerpay.test.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private final Long id;
    @NotBlank(message = "Content should not be blank!")
    private final String content;
}
