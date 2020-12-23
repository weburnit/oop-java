package vds.domain.entity.promotion.text;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vds.domain.entity.promotion.Promotion;

@Getter
@AllArgsConstructor
public abstract class TextPromotion extends Promotion {
    private final String content;
}
