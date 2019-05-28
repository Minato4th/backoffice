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
@Table(name = "diseases", schema = "public")
public class Diseases implements Serializable {

    private static final long serialVersionUID = -7675580052127119662L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_id")
    private Long diseaseId;

    @Column(name = "disease")
    private String disease;
}
