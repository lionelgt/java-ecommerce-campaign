package me.ecommerce.campaign.domain.service;

import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.domain.model.Price;

public interface PriceService {
    Price findPrice(PriceRequest priceRequest);
}
