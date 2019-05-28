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
@Table(name = "medicaments", schema = "public")
public class Medicaments implements Serializable {

    private static final long serialVersionUID = 8731312708876346537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicament_id")
    private Long medicamentId;

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;

    @Column(name = "dose")//todo changes
    private String dose;
}
