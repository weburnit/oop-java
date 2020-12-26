package vds.domain.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
public class Customer {
    private final Profile profile;
    private final Map<String, Object> customerProperties;
}
