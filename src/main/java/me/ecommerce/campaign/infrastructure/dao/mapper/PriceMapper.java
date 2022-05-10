package me.ecommerce.campaign.infrastructure.dao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import me.ecommerce.campaign.domain.model.Price;
import me.ecommerce.campaign.infrastructure.dao.entity.PriceEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {
    
    Price toModel(PriceEntity price);
}
