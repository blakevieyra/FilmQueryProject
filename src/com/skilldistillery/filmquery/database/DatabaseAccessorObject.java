package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			String sql = "SELECT * FROM film WHERE id = ?";
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				filmId = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int languageId = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> searchByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		Film film = null;
		try {
			String sql = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int languageId = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rentalRate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");
				film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures);
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

//	@Override
//	public List<Film> findFilmsById(int actorId) {
//		List<Film> films = new ArrayList<>();
//		try {
//			String sql = "SELECT * FROM film WHERE id = ?";
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, actorId);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				int filmId = rs.getInt("id");
//				String title = rs.getString("title");
//				String description = rs.getString("description");
//				short releaseYear = rs.getShort("release_year");
//				int languageId = rs.getInt("language_id");
//				int rentalDuration = rs.getInt("rental_duration");
//				double rentalRate = rs.getDouble("rental_rate");
//				int length = rs.getInt("length");
//				double replacementCost = rs.getDouble("replacement_cost");
//				String rating = rs.getString("rating");
//				String specialFeatures = rs.getString("special_features");
//				Film film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rentalRate,
//						length, replacementCost, rating, specialFeatures);
//				films.add(film);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return films;
//	}
//
//	@Override
//	public Actor findActorById(int actorId) {
//		Actor actor = null;
//		try {
//			String sql = "SELECT * FROM actor WHERE id = ?";
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, actorId);
//			ResultSet actorResult = stmt.executeQuery();
//			while (actorResult.next()) {
//				actorId = actorResult.getInt("id");
//				String firstName = actorResult.getString("first_name");
//				String lastName = actorResult.getString("last_name");
//				actor = new Actor(actorId, firstName, lastName);
//			}
//			actorResult.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return actor;
//	}
//
//	@Override
//	public List<Actor> findActorsByFilmId(int filmId) {
//
//		List<Actor> actorList = new ArrayList<>();
//		Actor actor = null;
//		try {
//			Connection conn = DriverManager.getConnection(url, user, pass);
//			String sql = "SELECT actor.first_name, actor.last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film ";
//			sql += "ON film.id = film_actor.film_id WHERE film_id = ?";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, filmId);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				actor = new Actor(firstName, lastName);
//				actorList.add(actor);
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return actorList;
//	}

}
