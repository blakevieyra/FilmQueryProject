package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int choice = 0;

		while (choice != 5) {
			System.out.println("Enter a number to choose from the following menu options:\n"
					+ " (1) Display film by film ID\n" + " (2) Display actor by actor ID\n"
					+ " (3) Display actors by film ID\n" + " (4) Search film by keyword\n" + " (5) QUIT");
			choice = input.nextInt();
			try {
				if (choice == 1) {
					System.out.println("Please enter a film ID.");
					int filmId = input.nextInt();
					if (filmId > 1000 || filmId <= 0) {
						System.err.println("Your out of range. Try again.");
					} else {
						System.out.println(db.findFilmById(filmId));
						System.out.println();
					}
				} else if (choice == 2) {
					System.out.println("Please enter an actor ID.");
					int actorID = input.nextInt();
					if (actorID > 200 || actorID <= 0) {
						System.err.println("Your out of range. Try again.");
					} else {
						System.out.println(db.findActorById(actorID));
						System.out.println();
					}
				} else if (choice == 3) {
					System.out.println("Please enter a film ID.");
					int filmId = input.nextInt();
					if (filmId > 1000 || filmId <= 0) {
						System.err.println("Your out of range. Try again.");
					} else {
						System.out.println(db.findActorsByFilmId(filmId));
						System.out.println();
					}
				
			} else if (choice == 4) {
				System.out.println("Please enter a film ID.");
				int filmId = input.nextInt();
				if (filmId > 1000 || filmId <= 0) {
					System.err.println("Your out of range. Try again.");
				} else {
					System.out.println(db.findActorsByFilmId(filmId));
					System.out.println();
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
