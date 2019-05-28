package com.event.backoffice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phones", schema = "public")
public class Phones implements Serializable {

    private static final long serialVersionUID = -226837468282410404L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Long phoneId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "polyclinics_id")
    private Polyclinics polyclinics;

    @Column(name = "person")
    private String person;

    @Column(name = "phone_number")
    private String phoneNumber;
}
