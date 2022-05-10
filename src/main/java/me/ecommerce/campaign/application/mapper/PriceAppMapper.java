package me.ecommerce.campaign.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.application.dto.PriceResponse;
import me.ecommerce.campaign.domain.model.Price;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceAppMapper {
    @Mapping(source = "price.priceList", target="priceList")
    @Mapping(source = "price.productId", target="productId")
    @Mapping(source = "price.brandId", target="brandId")
    @Mapping(source = "price.price", target="price")
    @Mapping(source = "priceRequest.applicationDate", target="applicationDate")
    PriceResponse toResponse(Price price, PriceRequest priceRequest);    
}
