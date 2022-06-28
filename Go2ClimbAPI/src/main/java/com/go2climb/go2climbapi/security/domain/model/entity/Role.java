package com.go2climb.go2climbapi.security.domain.model.entity;


import com.go2climb.go2climbapi.security.domain.model.enumeration.Roles;
import com.go2climb.go2climbapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Roles name;
}
