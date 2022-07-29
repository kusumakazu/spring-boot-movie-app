package com.example.libr.core.repo;

import com.example.libr.core.model.tabelmovie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long>
{
    Movie findByname(String nama_film);

}
