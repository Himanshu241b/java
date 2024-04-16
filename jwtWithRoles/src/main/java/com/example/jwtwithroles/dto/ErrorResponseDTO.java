package com.example.jwtwithroles.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponseDTO {
    private String message;
}
