package com.event.backoffice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGetDto {

    public String success;

    public boolean failReason;

    public UserInternalDto user;
}
