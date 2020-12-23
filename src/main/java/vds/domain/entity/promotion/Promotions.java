package vds.domain.entity.promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Promotions extends Promotion {
    private final List<Promotion> promotions;
}
