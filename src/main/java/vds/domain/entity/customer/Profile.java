package vds.domain.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Profile {
    private String name;
    private Integer age;
    private String job;
    private String country;
}
