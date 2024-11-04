package com.demo.UrlShortenerService.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "Url")
@Data
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "CreateAt", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "IpAddress", nullable = false)
    String ipAddress;

    @Column(name = "OriginalUrl", nullable = false)
    private String originalUrl;

    @Column(name = "TinyUrl", nullable = false)
    private String tinyUrl;

    @Column(name = "ExpireAt")
    private LocalDateTime expireAt;

    @Column(name = "Deleted")
    private boolean deleted;

    @Column(name = "Expire")
    private boolean expired;

}
