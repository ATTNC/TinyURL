package com.demo.UrlShortenerService.mapper;

import com.demo.UrlShortenerService.model.Url;
import com.demo.UrlShortenerService.payload.UrlResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UrlMapper implements Function<Url, UrlResponse> {

    @Override
    public UrlResponse apply(Url url) {
        return UrlResponse.builder()
                .originalUrl(url.getOriginalUrl())
                .tinyUrl(url.getTinyUrl())
                .createAt(url.getCreateAt())
                .expireAt(url.getExpireAt())
                .build();
    }

}
