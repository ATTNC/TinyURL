package com.demo.UrlShortenerService.config;

import com.demo.UrlShortenerService.model.Url;
import com.demo.UrlShortenerService.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExpireSchedule {

    private final UrlRepository repository;
    private final Logger logger = LoggerFactory.getLogger(ExpireSchedule.class);

    @Scheduled(cron = "0 * * ? * *")
    public void deleteExpiredUrls() {
        List<Url> expiredUrls = repository.expiredUrls(LocalDateTime.now());
        if (!expiredUrls.isEmpty()) {
            logger.info("Expire Task Start At: " + LocalDateTime.now());
            for (Url url : expiredUrls) {
                url.setDeleted(true);
                url.setExpired(true);
                repository.save(url);
            }
            logger.info("Expire Task End At: " + LocalDateTime.now());
        }
    }
}
