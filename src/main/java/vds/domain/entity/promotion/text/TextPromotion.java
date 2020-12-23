package vds.domain.entity.promotion.text;

import lombok.AllArgsConstructor;
import vds.domain.entity.promotion.Promotion;

@AllArgsConstructor
public abstract class TextPromotion extends Promotion {
    private final String content;
}
