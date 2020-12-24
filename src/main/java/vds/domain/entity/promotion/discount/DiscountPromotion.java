package vds.domain.entity.promotion.discount;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import vds.domain.entity.promotion.Promotion;

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class DiscountPromotion extends Promotion {
    private final Double percent;
    private final Long amount;

    public DiscountPromotion(String content, Double percent, Long amount) {
        super(content);
        this.percent = percent;
        this.amount = amount;
    }
}
