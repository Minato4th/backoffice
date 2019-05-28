package com.event.backoffice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @JsonProperty("id")
    private Long id;

    private String userName;

    private String email;

//    private String role;
//
//    private String company;
//
//    private String refCode;
//
//    private Boolean enabled;

}
