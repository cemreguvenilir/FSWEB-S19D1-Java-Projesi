package com.workintech.manytomany.util;

import com.workintech.manytomany.dto.ActorResponse;
import com.workintech.manytomany.dto.MovieActorResponse;
import com.workintech.manytomany.dto.MovieResponse;
import com.workintech.manytomany.entity.Actor;
import com.workintech.manytomany.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class HollywoodUtility {

    public static MovieActorResponse convertMovie(Movie movie, Actor actor){
        return new MovieActorResponse(movie, actor.getId(),
                actor.getFirstName(), actor.getLastName(), actor.getBirthDate());
    }

    public static List<ActorResponse> convertActorResponses(Movie movie){
        List<ActorResponse> actorResponses = new ArrayList<>();
        for(Actor actor : movie.getActorList()){
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate()));
        }
        return actorResponses;
    }
}
