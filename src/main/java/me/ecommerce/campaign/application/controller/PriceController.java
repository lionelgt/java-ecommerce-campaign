package me.ecommerce.campaign.application.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.application.dto.PriceResponse;
import me.ecommerce.campaign.application.mapper.PriceAppMapper;
import me.ecommerce.campaign.domain.model.Price;
import me.ecommerce.campaign.domain.service.PriceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/price")
public class PriceController {
    private final PriceService priceService;

    @GetMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PriceResponse findPrice(final @RequestBody  PriceRequest priceRequest) {
        Price price = priceService.findPrice(priceRequest);
        return  PriceAppMapper.INSTANCE.toResponse(price, priceRequest);
    }
}
