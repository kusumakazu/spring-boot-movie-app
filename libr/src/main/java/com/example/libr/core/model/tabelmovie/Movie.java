package com.example.libr.core.model.tabelmovie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id @GeneratedValue (strategy = AUTO)
    private Long id;
    private String name;
    private String sinopsis_film;

    @ManyToMany(fetch = EAGER)
    private Collection<Genre> genre = new ArrayList<>();
    private String harga_film;
    private String url_film;
    private String url_poster;


}
