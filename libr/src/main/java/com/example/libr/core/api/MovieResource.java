package com.example.libr.core.api;

import com.example.libr.core.Services.MovieService;
import com.example.libr.core.model.tabelmovie.Movie;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class MovieResource {

    private final MovieService movieService;

    @GetMapping(value = "/movie")
    public ResponseEntity<List<Movie>>getMovies()
    {
        return ResponseEntity.ok().body(movieService.getMovies());
    }

    @PostMapping(value = "/movie/save")
    public ResponseEntity<Movie>saveMovie(@RequestBody Movie movie)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/movie/save").toUriString());
        return ResponseEntity.created(uri).body(movieService.saveMovie(movie));
    }

    @PostMapping(value = "genre/addtomovie")
    public ResponseEntity<?>addGenreToMovie(@RequestBody GenreToMovie form)
    {
        movieService.addGenreToMovie(form.getNamaMovie_(), form.getNamaGenre_());
        return ResponseEntity.ok().build();
    }

}
@Data
class GenreToMovie
{
    private String namaMovie_;
    private String namaGenre_;
}
