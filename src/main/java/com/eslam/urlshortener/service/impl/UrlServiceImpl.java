package com.eslam.urlshortener.service.impl;

import com.eslam.urlshortener.dto.CreateUrlRequest;
import com.eslam.urlshortener.dto.UrlResponse;
import com.eslam.urlshortener.entity.UrlMapping;
import com.eslam.urlshortener.service.UrlService;
import lombok.*;

import org.springframework.stereotype.Service;
import com.eslam.urlshortener.repository.UrlRepository;

import java.security.SecureRandom;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepo;
    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final int SHORT_CODE_LENGTH = 6;

    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public UrlResponse createUrl(CreateUrlRequest req){
        String shortCode = generateShortCode();
        while (urlRepo.existsByShortCode(shortCode)) {
            shortCode = generateShortCode();
        }
        UrlMapping urlMapping = UrlMapping.builder().
                shortCode(shortCode).
                originalUrl(req.getUrl()).
                build();
        UrlMapping saved = urlRepo.save(urlMapping);
        return mapToResponse(saved);
    }
    @Override
    public UrlResponse getUrl(String shortCode) {
        return null;
    }

    @Override
    public List<UrlResponse> getAllUrls() {
        return List.of();
    }

    //helper function
    private String generateShortCode() {

        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {

            int index = RANDOM.nextInt(CHARACTERS.length());

            shortCode.append(CHARACTERS.charAt(index));

        }

        return shortCode.toString();
    }
    private UrlResponse mapToResponse(UrlMapping urlMapping) {
        return UrlResponse.builder()
                .id(urlMapping.getId())
                .shortCode(urlMapping.getShortCode())
                .url(urlMapping.getOriginalUrl())
                .build();
    }
}
