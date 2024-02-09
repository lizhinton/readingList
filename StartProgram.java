package controller;

import java.util.List;
import java.util.Scanner;
import model.book;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static bookHelper bh = new bookHelper();

		private static void addABook() {
			// TODO Auto-generated method stub
			book toAdd = new book();
			bh.insertBook(toAdd);
		}

		private static void deleteABook() {
			System.out.print("Enter the title of the book to delete: ");
			String title = in.nextLine();
			System.out.print("Enter the author of the book to delete: ");
			String author = in.nextLine();
			
			book toDelete = new book(title, author);
			bh.deleteBook(toDelete);
		}

		private static void editABook() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Title");
			System.out.println("2 : Search by Author");
			int searchBy = in.nextInt();
			in.nextLine();
			List<book> foundBook;
			if (searchBy == 1) {
				System.out.print("Enter the book title: ");
				String title = in.nextLine();
				foundBook = bh.searchForBookByTitle(title);
			} else {
				System.out.print("Enter the book author: ");
				String author = in.nextLine();
				foundBook = bh.searchForBookByAuthor(author);
			}

			if (!foundBook.isEmpty()) {
				System.out.println("Found Results.");
				for (book b : foundBook) {
					System.out.println(b.getId() + " : " + b.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				book toEdit = bh.searchForBookById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getAuthor());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Author");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New Author: ");
					String newAuthor = in.nextLine();
					toEdit.setAuthor(newAuthor);
				}

				bh.updateBook(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<book> allBooks = bh.showAllBooks();
			for(book singleItem : allBooks){
			System.out.println(singleItem.printBookDetails());
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome reading list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addABook();
				} else if (selection == 2) {
					editABook();
				} else if (selection == 3) {
					deleteABook();
				} else if (selection == 4) {
					viewTheList();
				} else {
					bh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

	}