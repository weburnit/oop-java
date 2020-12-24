package vds.domain.policy;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.entity.promotion.text.TextPromotion;

public interface PromotionVisitor {
    default void visit(Promotion promotion) {
        if (promotion instanceof DiscountPromotion) {
            visit((DiscountPromotion)promotion);
        } else if (promotion instanceof TextPromotion) {
            visit((TextPromotion)promotion);
        }
    }

    void visit(DiscountPromotion promotion);
    void visit(TextPromotion promotion);
}
