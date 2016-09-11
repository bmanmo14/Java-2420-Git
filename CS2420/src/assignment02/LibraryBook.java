package assignment02;

import java.util.GregorianCalendar;

/**
 * Brandon Mouser and Kale Thompson
 * 
 * This class extends the class Book and creates a library book with a unique
 * ISBN, an author, and a title. The functions in this class include getter
 * functions for getting the holder of the book as well as the due date. There
 * is also two functions that modify the holder and due date depending on
 * whether or not the book is checked in or out. The checkIn and checkout
 * functions.
 */

public class LibraryBook extends Book {

	private String bookHolder;
	private GregorianCalendar dueDate;

	/**
	 * This is a default constructor for the LibraryBook class.
	 */
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);

	}

	/**
	 * This is the getter function to get the holder.
	 * 
	 * @return string -- Person who checked the book out.
	 */
	public String getHolder() {
		return bookHolder;
	}

	/**
	 * This function returns the due date of a book.
	 * 
	 * @return GregorianCalendar -- The due date.
	 */
	public GregorianCalendar getDueDate() {
		return dueDate;
	}

	/**
	 * This function "checks in" book by setting the book holder and due date to
	 * null.
	 */
	public void checkIn() {
		this.bookHolder = null;
		this.dueDate = null;
	}

	/**
	 * This function "checks out" a book by setting its holder and due date.
	 * 
	 * @param name
	 * @param _dueDate
	 */
	public void checkout(String name, GregorianCalendar _dueDate) {
		this.bookHolder = name;
		this.dueDate = _dueDate;
	}

}
