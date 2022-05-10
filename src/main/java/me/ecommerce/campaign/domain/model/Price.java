package me.ecommerce.campaign.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ecommerce.campaign.domain.type.CurrencyType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Long priceList;
    private Long  brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private CurrencyType currencyType;
}
