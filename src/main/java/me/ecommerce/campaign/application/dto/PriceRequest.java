package me.ecommerce.campaign.application.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceRequest {
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
