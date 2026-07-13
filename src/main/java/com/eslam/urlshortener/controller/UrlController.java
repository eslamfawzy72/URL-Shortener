package com.eslam.urlshortener.controller;

import com.eslam.urlshortener.dto.CreateUrlRequest;
import com.eslam.urlshortener.dto.UrlResponse;
import com.eslam.urlshortener.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    public ResponseEntity<UrlResponse> createUrl(
            @Valid @RequestBody CreateUrlRequest request) {

        UrlResponse response = urlService.createUrl(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<UrlResponse> getUrl(
            @PathVariable String shortCode) {

        UrlResponse response = urlService.getUrl(shortCode);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UrlResponse>> getAllUrls() {

        List<UrlResponse> responses = urlService.getAllUrls();
        return ResponseEntity.ok(responses);
    }
}