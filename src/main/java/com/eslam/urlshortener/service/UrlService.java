package com.eslam.urlshortener.service;


import com.eslam.urlshortener.dto.CreateUrlRequest;
import com.eslam.urlshortener.dto.UrlResponse;

import java.util.List;


public interface UrlService {
    UrlResponse createUrl(CreateUrlRequest request);

    UrlResponse getUrl(String shortCode);

    List<UrlResponse> getAllUrls();
}
