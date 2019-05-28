package com.event.backoffice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolyclinicsDto {

    private Long clinicId;

    private String name;

    private String shortName;

    private String address;

    private List<String> remark;

    private Double latitude;

    private Double longitude;

    private Double rating;

    private List<PhonesDto> phones;

    private List<CommentsDto> comments;
}
