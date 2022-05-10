package me.ecommerce.campaign.infrastructure.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import lombok.RequiredArgsConstructor;
import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.domain.model.Price;
import me.ecommerce.campaign.domain.repository.PriceRepository;
import me.ecommerce.campaign.domain.service.PriceService;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;

    @Override
    public Price findPrice(PriceRequest priceRequest) {
        List<Price> prices = priceRepository.findPrice(priceRequest);
        return prices.stream().max(Comparator.comparing(Price::getPriority)).orElse(null);
    }
}
