package com.eslam.urlshortener.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUrlRequest {
    @NotBlank(message = "URL is required")
    private String url;

}
