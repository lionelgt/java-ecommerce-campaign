package me.ecommerce.campaign.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.application.dto.PriceResponse;
import me.ecommerce.campaign.domain.model.Price;

@Mapper
public interface PriceAppMapper {
    PriceAppMapper INSTANCE = Mappers.getMapper(PriceAppMapper.class);
    
    @Mapping(source = "price.priceList", target="priceList")
    @Mapping(source = "price.productId", target="productId")
    @Mapping(source = "price.brandId", target="brandId")
    @Mapping(source = "price.price", target="price")
    @Mapping(source = "priceRequest.applicationDate", target="applicationDate")
    PriceResponse toResponse(Price price, PriceRequest priceRequest);    
}
