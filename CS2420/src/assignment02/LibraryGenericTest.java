package assignment02;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Kale Thompson and Brandon Mouser Testing class for LibraryGeneric. This class
 * tests the LibraryGeneric class for any mistakes. Performs various tests to
 * check individual functions, and prints out an error message if anything went
 * amiss.
 */
public class LibraryGenericTest {

	public static void main(String[] args) {

		// test a library that uses names (String) to id patrons
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
		lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

		String patron1 = "Jane Doe";

		if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
			System.err.println("TEST FAILED: first checkout");
		if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
			System.err.println("TEST FAILED: second checkout");
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut1 = lib1
				.lookup(patron1);
		if (booksCheckedOut1 == null
				|| booksCheckedOut1.size() != 2
				|| !booksCheckedOut1.contains(new Book(9780330351690L,
						"Jon Krakauer", "Into the Wild"))
				|| !booksCheckedOut1.contains(new Book(9780374292799L,
						"Thomas L. Friedman", "The World is Flat"))
				|| !booksCheckedOut1.get(0).getHolder().equals(patron1)
				|| !booksCheckedOut1.get(0).getDueDate()
						.equals(new GregorianCalendar(2008, 1, 1))
				|| !booksCheckedOut1.get(1).getHolder().equals(patron1)
				|| !booksCheckedOut1.get(1).getDueDate()
						.equals(new GregorianCalendar(2008, 1, 1)))
			System.err.println("TEST FAILED: lookup(holder)");
		if (!lib1.checkin(patron1))
			System.err.println("TEST FAILED: checkin(holder)");

		// test a library that uses phone numbers (PhoneNumber) to id patrons
		LibraryGeneric<PhoneNumber> lib2 = new LibraryGeneric<PhoneNumber>();
		lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

		PhoneNumber patron2 = new PhoneNumber("801.555.1234");

		if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
			System.err.println("TEST FAILED: first checkout");
		if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
			System.err.println("TEST FAILED: second checkout");
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut2 = lib2
				.lookup(patron2);
		if (booksCheckedOut2 == null
				|| booksCheckedOut2.size() != 2
				|| !booksCheckedOut2.contains(new Book(9780330351690L,
						"Jon Krakauer", "Into the Wild"))
				|| !booksCheckedOut2.contains(new Book(9780374292799L,
						"Thomas L. Friedman", "The World is Flat"))
				|| !booksCheckedOut2.get(0).getHolder().equals(patron2)
				|| !booksCheckedOut2.get(0).getDueDate()
						.equals(new GregorianCalendar(2008, 1, 1))
				|| !booksCheckedOut2.get(1).getHolder().equals(patron2)
				|| !booksCheckedOut2.get(1).getDueDate()
						.equals(new GregorianCalendar(2008, 1, 1)))
			System.err.println("TEST FAILED: lookup(holder)");
		if (!lib2.checkin(patron2))
			System.err.println("TEST FAILED: checkin(holder)");
		LibraryGeneric<PhoneNumber> lib3 = new LibraryGeneric<PhoneNumber>();
		PhoneNumber person3 = new PhoneNumber("801-803-3785");

		lib3.add(978184319000L, "Moyra Caldecott", "Weapons of the Wolfhound");
		lib3.add(978184319001L, "Moyra Caldecott", "The Eye of Callanish");
		lib3.add(978184319002L, "Moyra Caldecott", "Crystal Legends");
		lib3.add(978184319003L, "Martyn Folkes",
				"Bath City Centre Street Map and Guide");
		lib3.add(978184319011L, "David Meade Betts", "Breaking the Gaze");
		lib3.checkout(978184319000L, person3, 3, 3, 2000);
		lib3.checkout(978184319001L, person3, 4, 4, 2001);
		lib3.checkout(978184319002L, person3, 3, 3, 2003);
		lib3.checkout(978184319003L, person3, 6, 6, 2004);
		lib3.checkout(978184319011L, person3, 5, 5, 2000);

		// This prints and tests an overDue list. Bath City Centre Street Map and Guide should not be included.
		// The first item should be Weapons of the Wolfhound. The last item should Crystal Legends.
		System.out.println(lib3.getOverdueList(4, 4, 2004) + "\n");

		// This prints out a list of all the books in the library in alphabetical order from the author.
		System.out.println(lib3.getOrderedByAuthor() + "\n");

		// This prints out a list of all the books in the library in order of their ISBN. Lowest first.
		System.out.println(lib3.getInventoryList() + "\n");

		// If this prints without any other text, then the tests have passed. :D
		System.out.println("Testing done.");
	}
}
