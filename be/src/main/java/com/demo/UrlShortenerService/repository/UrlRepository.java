package com.demo.UrlShortenerService.repository;

import com.demo.UrlShortenerService.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UrlRepository extends JpaRepository<Url, UUID> {
    boolean existsUrlByTinyUrlAndDeletedFalseAndExpiredFalse(@Param("tinyUrl") String tinyUrl);
    Optional<Url> findByTinyUrl(@Param("tinyUrl") String tinyUrl);
    @Query("select u from Url u where u.deleted = false and u.expireAt <= :time")
    List<Url> expiredUrls(@Param("time") LocalDateTime time);
}
