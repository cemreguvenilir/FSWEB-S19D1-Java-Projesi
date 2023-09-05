package com.workintech.manytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private int movieId;
    private String name;
    private String directorName;
    private double rating;
    private LocalDate releaseDate;

}
