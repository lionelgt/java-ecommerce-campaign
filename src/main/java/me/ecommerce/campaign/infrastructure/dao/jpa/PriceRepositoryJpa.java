package me.ecommerce.campaign.infrastructure.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import me.ecommerce.campaign.infrastructure.dao.entity.PriceEntity;

@Repository
public interface PriceRepositoryJpa extends JpaRepository<PriceEntity, Long> {
    
    @Query(value = " select p from PriceEntity p where p.productId = :productId " 
            + " and  p.brandId = :brandId and :applicationDate BETWEEN p.startDate and p.endDate ")
    List<PriceEntity> findPrice(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate") LocalDateTime applicationDate);
}
