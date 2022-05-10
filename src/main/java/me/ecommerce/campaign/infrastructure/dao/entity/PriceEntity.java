package me.ecommerce.campaign.infrastructure.dao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRICES")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column( name = "PRICE_LIST")
    private Long priceList;
    
    @Column( name = "BRAND_ID")
    private Long  brandId;
    
    @Column( name = "START_DATE")
    private LocalDateTime startDate;
    
    @Column( name = "END_DATE")
    private LocalDateTime endDate;  
    
    @Column( name = "PRODUCT_ID")
    private Long productId;
    
    @Column( name = "PRIORITY")
    private Long priority;
    
    @Column( name = "PRICE")
    private BigDecimal price;
    
    @Column( name = "CURR")
    private String CurrencyType;
}
