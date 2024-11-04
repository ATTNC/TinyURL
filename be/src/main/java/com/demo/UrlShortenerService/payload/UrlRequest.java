package com.demo.UrlShortenerService.payload;

import com.demo.UrlShortenerService.model.Url;

import java.time.Duration;
import java.time.LocalDateTime;

public record UrlRequest(String url, Long expireTime) {
    public Url toEntity(UrlRequest request, String tinyUrl, String ipAddr) {
        Url entity = new Url();
        entity.setIpAddress(ipAddr);
        entity.setOriginalUrl(request.url());
        entity.setTinyUrl(tinyUrl);
        entity.setCreateAt(LocalDateTime.now());
        entity.setDeleted(false);
        if (request.expireTime() != null) {
            Duration duration = Duration.ofSeconds(request.expireTime());
            LocalDateTime expireDate = entity.getCreateAt().plus(duration);
            entity.setExpireAt(expireDate);
        }
        return entity;
    }
}
