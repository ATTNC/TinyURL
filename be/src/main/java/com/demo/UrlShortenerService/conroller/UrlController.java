package com.demo.UrlShortenerService.conroller;

import com.demo.UrlShortenerService.payload.UrlRequest;
import com.demo.UrlShortenerService.payload.UrlResponse;
import com.demo.UrlShortenerService.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UrlController {

    private final UrlService service;

    @PostMapping("/tiny_url")
    public ResponseEntity<UrlResponse> tinyUrl(@RequestBody UrlRequest request) {
        var ipAddr = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest().getRemoteAddr();
        var response = service.shortenUrl(request, ipAddr);
        return ResponseEntity.ok(response);
    }

    @GetMapping("original_url")
    public ResponseEntity<UrlResponse> originalUrl(@RequestBody UrlRequest request) {
        var response = service.originalUrl(request.url());
        return ResponseEntity.ok(response);
    }
}
