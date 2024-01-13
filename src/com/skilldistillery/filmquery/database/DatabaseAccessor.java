package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	Film findFilmById(int filmId);

	List<Film> searchByKeyword(String keyword);

	List<Actor> findActorsByFilmId(int filmId);
//	Actor findActorById(int actorId);
//

//	List<Film> findFilmsById(int filmId);
}
