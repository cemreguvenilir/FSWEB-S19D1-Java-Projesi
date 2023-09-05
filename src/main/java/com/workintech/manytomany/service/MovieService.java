package com.workintech.manytomany.service;

import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(int id);
    Movie save(Movie movie);
    Movie delete(int id);
}
