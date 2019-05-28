package com.event.backoffice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "polyclinics", schema = "public")
public class Polyclinics implements Serializable {

    private static final long serialVersionUID = 3055334097512989177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinic_id")
    private Long clinicId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "polyclinics", cascade = CascadeType.ALL)
    private List<Remarks> remarks;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "region")
    private String region;

    @OneToMany(mappedBy = "polyclinics", cascade = CascadeType.ALL)
    private List<Ratings> rating;

    @OneToMany(mappedBy = "polyclinics", cascade = CascadeType.ALL)
    private List<Phones> phones;

    @OneToMany(mappedBy = "polyclinics", cascade = CascadeType.ALL)
    private List<Comments> comments;
}
