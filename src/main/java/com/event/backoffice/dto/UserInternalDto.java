package com.event.backoffice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInternalDto {

    public String guid;

    public String name;

    public String email;

    public String token;

    public String unit;

    public Long points;

}
