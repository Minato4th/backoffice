package com.event.backoffice.model;

import com.event.backoffice.converter.LocalDateTimeConverter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings", schema = "public")
public class Ratings implements Serializable {

    private static final long serialVersionUID = 4935267016566262189L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "polyclinics_id")
    private Polyclinics polyclinics;

//    @Column(name = "user_id")//TODO: refactor when user will be available BD
//    private String user_id;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "creation_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationTime;
}
