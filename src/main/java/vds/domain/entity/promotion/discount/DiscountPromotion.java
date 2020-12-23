package vds.domain.entity.promotion.discount;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DiscountPromotion {
    private final String content;
    private final Double percent;
    private final Long amount;
}
