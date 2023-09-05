package com.workintech.manytomany.controller;

import com.workintech.manytomany.dto.ActorResponse;
import com.workintech.manytomany.dto.MovieActorResponse;
import com.workintech.manytomany.dto.MovieActorRequest;
import com.workintech.manytomany.dto.MovieResponse;
import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;
import com.workintech.manytomany.service.MovieService;
import com.workintech.manytomany.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/")
    public List<MovieResponse> findAll(){
        List<MovieResponse> responses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for(Movie movie: movies){
             responses.add(new MovieResponse(movie.getId(), movie.getName(),
                     movie.getDirectorName(), movie.getRating(), movie.getReleaseDate()));
        }
        return responses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id){
        Movie movie = movieService.findById(id);
        return new MovieResponse(movie.getId(), movie.getName(),
                movie.getDirectorName(), movie.getRating(), movie.getReleaseDate());
    }

    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest){
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertMovie(savedMovie, actor);
    }

    @PostMapping("/addActor/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId){
        Movie movie = movieService.findById(movieId);
        movie.addAllActor(actors);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertActorResponses(savedMovie);

    }
    @PutMapping("/{id}")
    public MovieResponse update(@PathVariable int id, @RequestBody Movie movie){
        Movie foundMovie = movieService.findById(id);
            movie.setId(id);
            movie.setActorList(foundMovie.getActorList());
            Movie updatedMovie = movieService.save(movie);
            return new MovieResponse(movie.getId(), movie.getName(),
                    movie.getDirectorName(), movie.getRating(), movie.getReleaseDate());

    }
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id){
        Movie movie = movieService.delete(id);
        return new MovieResponse(movie.getId(), movie.getName(),
                movie.getDirectorName(), movie.getRating(), movie.getReleaseDate());
    }
}
