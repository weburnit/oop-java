package vds.domain.entity.customer;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Profile {
    private String name;
    private Integer age;
    private String job;
    private String country;
}
