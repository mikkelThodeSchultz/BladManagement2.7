package com.example.cykelrytter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class SoMeLink { //Might be redundant
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String soMeLink;

    @ManyToOne
    @JsonBackReference //Undgår et evigt cirkulært metodekald fra @RestController
    private Artist artist;

}
