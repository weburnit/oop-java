package vds.domain.entity.promotion.text;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import vds.domain.entity.promotion.Promotion;

@Getter
@EqualsAndHashCode(callSuper = true)
public abstract class TextPromotion extends Promotion {
    public TextPromotion(String content) {
        super(content);
    }
}
