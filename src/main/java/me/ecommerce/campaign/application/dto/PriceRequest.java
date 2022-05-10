package me.ecommerce.campaign.application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {
    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
}
