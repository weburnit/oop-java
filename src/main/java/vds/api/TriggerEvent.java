package vds.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TriggerEvent {
    private String name;
    private Profile profile;
}
