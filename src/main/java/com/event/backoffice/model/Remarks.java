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
@Table(name = "remarks", schema = "public")
public class Remarks implements Serializable{

    private static final long serialVersionUID = 5138186622781682333L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "remark_id")
    private Long remarkId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "polyclinics_id")
    private Polyclinics polyclinics;

    @Column(name = "remark")
    private String remark;
}
