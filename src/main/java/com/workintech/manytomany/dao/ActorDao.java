package com.workintech.manytomany.dao;

import com.workintech.manytomany.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<Actor, Integer> {
}
