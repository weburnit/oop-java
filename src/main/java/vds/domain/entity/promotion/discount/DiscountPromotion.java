package vds.domain.entity.promotion.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vds.domain.entity.promotion.Promotion;

@Getter
@AllArgsConstructor
public abstract class DiscountPromotion extends Promotion {
    private final String content;
    private final Double percent;
    private final Long amount;
}
