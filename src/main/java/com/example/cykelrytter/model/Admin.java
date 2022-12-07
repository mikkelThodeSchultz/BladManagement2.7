package com.example.cykelrytter.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.criteria.internal.predicate.PredicateImplementor;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;
    @Column
    private String username;

    public Admin(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public <E> Admin(String password, String username, ArrayList<E> es) {
    }
}
