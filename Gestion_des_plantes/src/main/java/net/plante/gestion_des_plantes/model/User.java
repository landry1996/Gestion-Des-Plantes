package net.plante.gestion_des_plantes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Collection<Plant> plants = new ArrayList<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Collection<Notification> notifications = new ArrayList<>();

}
