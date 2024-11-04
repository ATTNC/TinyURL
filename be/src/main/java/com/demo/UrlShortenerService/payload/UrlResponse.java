package com.demo.UrlShortenerService.payload;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UrlResponse(String originalUrl, String tinyUrl, LocalDateTime createAt,
                          LocalDateTime expireAt) {

}
