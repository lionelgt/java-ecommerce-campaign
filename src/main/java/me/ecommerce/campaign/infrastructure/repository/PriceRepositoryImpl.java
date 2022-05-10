package me.ecommerce.campaign.infrastructure.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.domain.model.Price;
import me.ecommerce.campaign.domain.repository.PriceRepository;
import me.ecommerce.campaign.infrastructure.dao.entity.PriceEntity;
import me.ecommerce.campaign.infrastructure.dao.jpa.PriceRepositoryJpa;
import me.ecommerce.campaign.infrastructure.dao.mapper.PriceMapper;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceRepositoryJpa priceRepositoryJpa;

    @Override
    public List<Price> findPrice(PriceRequest priceRequest) {
        List<PriceEntity> prices = priceRepositoryJpa.findPrice(priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getApplicationDate());
        return prices.stream().map(PriceMapper.INSTANCE::toModel).collect(Collectors.toList());
    }
}
