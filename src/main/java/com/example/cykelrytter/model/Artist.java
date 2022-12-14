package com.example.cykelrytter.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column (columnDefinition="TEXT")
    private String description;

    private String agent;
    private String imageLink;
    private String youtubeLink;
    private String facebookLink;
    private String instagramLink;
    private String spotifyLink;
    private String tikTokLink;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
    //private Set<SoMeLink> soMeLinks =new HashSet<>();
}
