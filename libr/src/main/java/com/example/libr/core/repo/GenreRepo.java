package com.example.libr.core.repo;

import com.example.libr.core.model.tabelmovie.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long>
{
    Genre findByGenre(String genre_film);
}
