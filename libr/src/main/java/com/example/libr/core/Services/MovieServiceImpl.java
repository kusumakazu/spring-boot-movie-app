package com.example.libr.core.Services;

import com.example.libr.core.model.tabelmovie.Genre;
import com.example.libr.core.model.tabelmovie.Movie;
import com.example.libr.core.repo.GenreRepo;
import com.example.libr.core.repo.MovieRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MovieServiceImpl implements MovieService{

    private final MovieRepo movieRepo;
    private final GenreRepo genreRepo;

    @Override
    public Movie saveMovie(Movie movie) {

        log.info("menyimpan Judul Film {} ke Database ",movie.getName());
        return movieRepo.save(movie);
    }

    @Override
    public Genre saveGenre(Genre genre) {
        log.info("menyimpan Jenis Genre {} ke Database ",genre.getGenre());
        return genreRepo.save(genre);
    }

    @Override
    public void addGenreToMovie(String nama_movie, String nama_Genre) {
        log.info("Menambahkan jenis Genre {} ke Movie by Nama {}", nama_Genre, nama_movie);
        Movie movie = movieRepo.findByname(nama_movie);
        Genre genre = genreRepo.findByGenre(nama_Genre);

        movie.getGenre().add(genre);
    }

    @Override
    public Movie getMovieName(String movie_name) {

        log.info("Mengambil Data nama Movie by nama {} ", movie_name);
        return movieRepo.findByname(movie_name);
    }

    @Override
    public List<Movie> getMovies() {
        log.info("Mengambil Semua Data User ");
        return movieRepo.findAll();
    }
}
