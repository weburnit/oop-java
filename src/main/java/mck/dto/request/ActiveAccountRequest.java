package mck.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActiveAccountRequest {
    public int ID;
    public String Code;

    @JsonCreator
    private ActiveAccountRequest(@JsonProperty("id") int id, @JsonProperty("code") String code) {
        this.ID = id;
        this.Code = code;
    }

    public static ActiveAccountRequest Create(int id, String code){
        return new ActiveAccountRequest(id, code);
    }
}
