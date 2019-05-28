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
@Table(name = "user", schema = "public")
public class User implements Serializable {

    private static final long serialVersionUID = 2527956299820570815L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

//    @Column(name = "role")
//    private String role;
//
//    @Column(name = "company")
//    private String company;
//
//    @Column(name = "ref_code")
//    private String refCode;
//
//    @Column(name = "enabled")
//    private Boolean enabled;
}
