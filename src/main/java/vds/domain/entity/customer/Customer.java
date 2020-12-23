package vds.domain.entity.customer;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Customer {
    private final Profile profile;
    private final Map<String, Object> customerProperties;
}
