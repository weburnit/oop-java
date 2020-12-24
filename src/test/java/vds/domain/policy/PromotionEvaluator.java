package vds.domain.policy;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.entity.promotion.text.TextPromotion;

public class PromotionEvaluator implements PromotionVisitor {

    @Override
    public void visit(DiscountPromotion promotion) {
        StringBuilder discountStr = new StringBuilder();
        if (promotion.getPercent() == null) {
            discountStr.append(promotion.getAmount());
            discountStr.append("(VND)");
        } else {
            discountStr.append(promotion.getPercent());
            discountStr.append("%");
        }
        System.out.println("Message=" + promotion.getContent() + ", discount " + discountStr.toString());
    }

    @Override
    public void visit(TextPromotion promotion) {
        System.out.println("Message=" + promotion.getContent());
    }
}
