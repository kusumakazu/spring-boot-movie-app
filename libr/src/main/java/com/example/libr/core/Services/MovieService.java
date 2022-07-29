package com.example.libr.core.Services;

import com.example.libr.core.model.tabelmovie.Genre;
import com.example.libr.core.model.tabelmovie.Movie;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);
    Genre saveGenre(Genre genre);

    void addGenreToMovie(String nama_movie,String nama_Genre);

    Movie getMovieName(String movie_name);
    List<Movie>getMovies();


}
