package com.workintech.manytomany.service;

import com.workintech.manytomany.dao.MovieDao;
import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;
import com.workintech.manytomany.exceptions.MovieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    private MovieDao movieDao;

    @Autowired
    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> movie = movieDao.findById(id);
        if(movie.isPresent()){
            return movie.get();
        }
        throw new MovieException("movie is not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie delete(int id) {
        Movie movie = findById(id);
        movieDao.delete(movie);
        return movie;
    }
}
