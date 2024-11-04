package com.demo.UrlShortenerService.service;

import com.demo.UrlShortenerService.mapper.UrlMapper;
import com.demo.UrlShortenerService.payload.UrlRequest;
import com.demo.UrlShortenerService.payload.UrlResponse;
import com.demo.UrlShortenerService.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository repository;
    private final UrlMapper mapper;

    @Value("${url.hash-length}")
    private int HASH_LENGTH;

    @Value("${url.base62}")
    private String BASE62;

    @Value("${url.fe-domain}")
    private String domain;

    public UrlResponse shortenUrl(UrlRequest request, String ipAddr) {
        var tinyUrl = domain + generateTinyUrl();
        var entity = request.toEntity(request, tinyUrl, ipAddr);
        repository.save(entity);
        return mapper.apply(entity);
    }

    public UrlResponse originalUrl(String tinyUrl) {
        var url = repository.findByTinyUrl(tinyUrl);
        return url.map(mapper).orElse(null);
    }

    private String generateTinyUrl() {
        String hash;
        do {
            hash = generateRandomHash();
        } while (repository.existsUrlByTinyUrlAndDeletedFalseAndExpiredFalse(hash));
        return hash;
    }

    private String generateRandomHash() {
        StringBuilder sb = new StringBuilder(HASH_LENGTH);
        Random random = new Random();
        for (int i = 0; i < HASH_LENGTH; i++) {
            sb.append(BASE62.charAt(random.nextInt(HASH_LENGTH)));
        }
        return sb.toString();
    }

}
