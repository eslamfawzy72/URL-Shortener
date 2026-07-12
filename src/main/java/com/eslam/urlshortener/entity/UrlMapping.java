package com.eslam.urlshortener.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "url_mappings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlMapping {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "short_code", nullable = false, unique = true,length = 8)
private String shortCode;

@Column(name = "original_url",nullable = false)
private String originalUrl;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;



    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }


    }
