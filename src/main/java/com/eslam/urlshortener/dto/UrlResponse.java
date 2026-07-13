package com.eslam.urlshortener.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlResponse  implements Serializable {

    private static final long serialVersionUID= 1L;

    private Long id;

    private String shortCode;

    private String url;

}