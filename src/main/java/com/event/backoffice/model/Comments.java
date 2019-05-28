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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments", schema = "public")
public class Comments implements Serializable {

    private static final long serialVersionUID = -2786894111427327691L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private Long commentsId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "polyclinics_id")
    private Polyclinics polyclinics;

//    @Column(name = "user_id")//TODO: refactor when user will be available BD
//    private String user_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "creation_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationTime;// TODO: refactor date and time
}
