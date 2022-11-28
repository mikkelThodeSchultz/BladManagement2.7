package com.example.cykelrytter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String teamName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Set<Rider> riders = new HashSet<>();

}
