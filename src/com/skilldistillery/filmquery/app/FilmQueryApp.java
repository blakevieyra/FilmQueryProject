package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
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
		int filmId = 0;

		while (choice != 3) {
			System.out.println("Enter a number to choose from the following menu options:\n"
					+ " (1) Display film by film ID\n" + " (2) Search film by keyword\n" + " (3) Quit");
			try {
				choice = input.nextInt();
				if (choice == 1) {
					System.out.println("Please enter a film ID.");
					try {
						filmId = input.nextInt();
						if (filmId > 1000 || filmId <= 0) {
							System.err.println("Your out of range. Please try again.");
						} else {
							System.out.println(db.findFilmById(filmId));
							System.out.println();
						}
					} catch (InputMismatchException e) {
						System.err.println("Please enter a number.");
						input.next();
					}

				} else if (choice == 2) {
					System.out.println("Please enter a title or description keyword.");
					try {
						String keyword = input.next();
						if (db.searchByKeyword(keyword).isEmpty()) {
							System.out.println("No results found. Please try again.\n");
						} else {
							System.out.println(db.searchByKeyword(keyword));
						}
					} catch (Exception e) {
						System.out.println("Please enter a word.");
						input.next();
					}
				}
			} catch (Exception e) {
				System.err.println("Please enter a number.");
				input.next();
			}

		}

	}
//				else if (choice == 2) {
//					System.out.println("Please enter an actor ID.");
//					int actorID = input.nextInt();
//					if (actorID > 200 || actorID <= 0) {
//						System.err.println("Your out of range. Try again.");
//					} else {
//						System.out.println(db.findActorById(actorID));
//						System.out.println();
//					}
//				} else if (choice == 3) {
//					System.out.println("Please enter a film ID.");
//					int filmId = input.nextInt();
//					if (filmId > 1000 || filmId <= 0) {
//						System.err.println("Your out of range. Try again.");
//					} else {
//						System.out.println(db.findActorsByFilmId(filmId));
//						System.out.println();
//					}
//
//				} 
}
