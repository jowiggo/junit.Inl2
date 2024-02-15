package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		// Skapa två identiska böcker
		Book book1 = new Book(1, "Learning Java", "Author", "ISBN", "Genre", 200);
		Book book2 = new Book(1, "Learning Java", "Author", "ISBN", "Genre", 200);

		// Kontrollera att de två böckerna anses vara lika
		assertEquals(book1, book2);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		// Skapa två böcker med olika attributvärden
		Book book1 = new Book(1, "Learning Java", "Author", "ISBN", "Genre", 200);
		Book book2 = new Book(2, "Mastering Python", "Author", "ISBN", "Genre", 300);

		// Kontrollera att de två böckerna anses vara olika
		assertNotEquals(book1, book2);
	}

}
