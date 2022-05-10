package me.ecommerce.campaign.domain.repository;

import java.util.List;

import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.domain.model.Price;

public interface PriceRepository {
    List<Price> findPrice(PriceRequest priceRequest);
}

