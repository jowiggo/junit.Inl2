package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		Book book1 = new Book(1,"Learning Java","Author","ISBN","Genre", 0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book bookToAdd = new Book(1, "Learning Java", "Author", "ISBN", "Genre", 0);
		BookCatalog bookCat = new BookCatalog();
		bookCat.addBook(bookToAdd);

		int numberOfBooks = bookCat.getNumberOfBooks();

		assertEquals(1, numberOfBooks);
	}

	//G
	@Test
	public void testFindBook() {
		String titleToFind = "Learning Java";

		try {
			Book foundBook = bc.findBook(titleToFind);

			assertNotNull(foundBook);

			assertEquals(titleToFind, foundBook.getTitle());
		} catch (BookNotFoundException e) {
			fail("Boken '" + titleToFind + "' hittades inte: " + e.getMessage());
		}
	}

	//G
	@Test
	public void testFindBookIgnoringCase() {

		String titleToFind = "learning java";

		try {
			Book foundBook = bc.findBook(titleToFind);

			assertNotNull(foundBook);

			assertEquals("Learning Java", foundBook.getTitle());
		} catch (BookNotFoundException e) {
			fail("Boken '" + titleToFind + "' hittades inte (ignorera skiftläge): " + e.getMessage());
		}
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() throws BookNotFoundException {

		Book book1 = new Book(1,"Learning","","","",0);
		bc.addBook(book1);
		Book book2 = bc.findBook("  Learning    ");
		assertEquals(book1, book2);

	}


	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {

	}

}
