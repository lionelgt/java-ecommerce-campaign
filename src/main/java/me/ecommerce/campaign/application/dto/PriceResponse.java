package me.ecommerce.campaign.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PriceResponse {
    private Long productId;
    private Long  brandId;
    private Long priceList;
    private LocalDateTime applicationDate;
    private BigDecimal price;
}
