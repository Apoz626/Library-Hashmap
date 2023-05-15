import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * The Library class
 * 
 * @author Anthony Positano
 *
 */
public class Library {

	/**
	 * Prints a menu with all available options for the user
	 */
	public void printMenu() {
		System.out.println("LIBRARY MENU");
		System.out.println("l - List Available Books");
		System.out.println("c - Check-Out a Book");
		System.out.println("b - Return a Book");
		System.out.println("a - Search by Author");
		System.out.println("r - Search by Rating");
		System.out.println("y - Search by Year");
		System.out.println("q - Quit\n");
	}

	/**
	 * Receives an entry from the user as well as the HashMap to then execute the
	 * correct menu option
	 * 
	 * @param scnr     Scanner object to collect the user inputs
	 * @param userChar char variable to select the option
	 * @param books    HashMap with all stored Book object information
	 */
	public void executeMenu(Scanner scnr, char userChar, HashMap<String, Book> books) {
		if (userChar == 'l') {
			System.out.println("Available Books: Title / Author / Genre");
			System.out.println("\t\t Year / Rating / Copies\n");
			listBooks(books);
		}

		else if (userChar == 'c') {
			System.out.println("Enter Title to Check-Out: ");
			scnr.nextLine();
			String title = scnr.nextLine();
			checkOut(title, books);
		}

		else if (userChar == 'b') {
			System.out.println("Enter Title to Return: ");
			scnr.nextLine();
			String title = scnr.nextLine();
			returnBook(title, books);
		}

		else if (userChar == 'a') {
			System.out.println("Enter Author's Name: ");
			scnr.nextLine();
			String author = scnr.nextLine();
			queryAuthor(author, books);
		}

		else if (userChar == 'r') {
			System.out.println("Enter Rating: ");
			scnr.nextLine();
			double rating = scnr.nextDouble();

			queryRating(rating, books);
		}

		else if (userChar == 'y') {
			System.out.println("Enter Year: ");
			scnr.nextLine();
			int year = scnr.nextInt();
			queryYear(year, books);
		}
	}

	/**
	 * Lists the books in summary fashion
	 * 
	 * @param books HashMap containing all of the Book object info
	 */
	public static void listBooks(HashMap<String, Book> books) {
		Iterator<Entry<String, Book>> it = books.entrySet().iterator();

		while (it.hasNext()) {
			Entry<String, Book> entry = it.next();
			System.out.println(
					entry.getKey() + " / " + entry.getValue().getAuthor() + " / " + entry.getValue().getCategory());
			System.out.println(entry.getValue().getYear() + " / " + entry.getValue().getRating() + " / "
					+ entry.getValue().getCopies());
			System.out.println("----------------");
		}

	}

	/**
	 * Allows user to check out a book decrementing the available copies by 1
	 * 
	 * @param title User inputed title to check out
	 * @param books HashMap with all Book object info
	 */
	public static void checkOut(String title, HashMap<String, Book> books) {
		if (books.containsKey(title)) {
			if (books.get(title).getCopies() == 0) {
				System.out.println("No More Copies");
			}

			else {
				int copies = books.get(title).getCopies();
				copies -= 1;
				books.get(title).setCopies(copies);

				System.out.println("Checked Out: " + books.get(title).getTitle());
			}
		}

		else {
			System.out.println("Title not available at this library");
		}
	}

	/**
	 * Allows user to return a book incrementing the available copies by 1
	 * 
	 * @param title User inputed title to return
	 * @param books HashMap with all Book object info
	 */
	public static void returnBook(String title, HashMap<String, Book> books) {
		if (books.containsKey(title)) {
			int copies = books.get(title).getCopies();
			copies += 1;
			books.get(title).setCopies(copies);

			System.out.println("Returned: " + books.get(title).getTitle());

		}

		else {
			System.out.println("Title not available at this library");
		}
	}

	/**
	 * Searches for all books with the same author
	 * 
	 * @param author User inputed author to search for
	 * @param books  HashMap with all Book object info
	 */
	public static void queryAuthor(String author, HashMap<String, Book> books) {
		Iterator<Entry<String, Book>> it = books.entrySet().iterator();
		int counter = 0;

		System.out.println("Books by " + author + ": Title / Copies\n");

		while (it.hasNext()) {
			Entry<String, Book> entry = it.next();

			if (entry.getValue().getAuthor().equals(author)) {
				System.out.println(entry.getKey() + " / " + entry.getValue().getCopies());
				++counter;
			}

		}

		if (counter == 0) {
			System.out.println("Invalid Author");
		}

	}

	/**
	 * Lets the user to search for all books equal to or greater than the inputed
	 * rating
	 * 
	 * @param rating User inputed rating to search for
	 * @param books  HashMap with all Book object info
	 */
	public static void queryRating(double rating, HashMap<String, Book> books) {
		Iterator<Entry<String, Book>> it = books.entrySet().iterator();
		int counter = 0;

		System.out.println("Books Above " + rating + " Rating: Title / Author");
		System.out.println("\t\t\tRating / Copies\n");

		while (it.hasNext()) {
			Entry<String, Book> entry = it.next();

			if (entry.getValue().getRating() >= rating) {
				System.out.println(entry.getKey() + " / " + entry.getValue().getAuthor());
				System.out.println(entry.getValue().getRating() + " / " + entry.getValue().getCopies());
				System.out.println("----------------");
				++counter;
			}

		}

		if (counter == 0) {
			System.out.println("No books above a" + rating + " rating");
		}

	}

	/**
	 * Allows user to search for all books written on the given year
	 * 
	 * @param year  User inputed year to search for
	 * @param books HashMap with all Book object info
	 */
	public static void queryYear(int year, HashMap<String, Book> books) {
		Iterator<Entry<String, Book>> it = books.entrySet().iterator();
		int counter = 0;

		System.out.println("Books Written in " + year + ": Title / Author");
		System.out.println("\t\t       Year / Copies\n");

		while (it.hasNext()) {
			Entry<String, Book> entry = it.next();

			if (entry.getValue().getYear() == year) {
				System.out.println(entry.getKey() + " / " + entry.getValue().getAuthor());
				System.out.println(entry.getValue().getYear() + " / " + entry.getValue().getCopies());
				System.out.println("----------------");
				++counter;
			}

		}

		if (counter == 0) {
			System.out.println("No books written on " + year);
		}

	}

	/**
	 * Contains the logic for instantiating each Book class and inputting it into
	 * the HashMap. Also contains the logic for starting printMenu() method and
	 * collecting the user response to then start the executeMenu() method.
	 * 
	 * @param args The Command Line Argument
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		HashMap<String, Book> books = new HashMap<String, Book>();
		Library l1 = new Library();
		char userChar = '0';

		books.put("The Hobbit", new Book("The Hobbit", "Tolkien", "Fiction", 1937, 4.9, 3));
		books.put("The Fellowship of the Ring",
				new Book("The Fellowship of the Ring", "Tolkien", "Fiction", 1954, 4.8, 2));
		books.put("The Two Towers", new Book("The Two Towers", "Tolkien", "Fiction", 1966, 3.1, 1));
		books.put("The Return of the King", new Book("The Return of the King", "Tolkien", "Fiction", 1966, 2.5, 3));
		books.put("Brief History of Time", new Book("Brief History of Time", "Hawking", "NonFiction", 1988, 3.5, 2));
		books.put("1984", new Book("1984", "Orwell", "Fiction", 1948, 4.7, 10));
		books.put("Animal Farm", new Book("Animal Farm", "Orwell", "Fiction", 1944, 4.7, 8));
		books.put("Catch-22", new Book("Catch-22", "Heller", "Fiction", 1922, 4.3, 6));
		books.put("Anna Karenina", new Book("Anna Karenina", "Tolstoy", "Fiction", 1878, 4.3, 7));
		books.put("War and Peace", new Book("War and Peace", "Tolstoy", "Fiction", 1865, 4.5, 6));
		books.put("A Confession", new Book("A Confession", "Tolstoy", "Fiction", 1882, 4.5, 5));
		books.put("How to Win Friends and Influence People",
				new Book("How to Win Friends and Influence People", "Carnegie", "NonFiction", 1936, 4.3, 1));
		books.put("Freakonomics", new Book("Freakonomics", "Levitt", "NonFiction", 2005, 4.9, 7));
		books.put("Super Freakonomics", new Book("Super Freakonomics", "Levitt", "NonFiction", 2009, 4.9, 2));
		books.put("Think like a freak", new Book("Think like a freak", "Levitt", "NonFiction", 2014, 4.9, 6));
		books.put("Gray's Anatomy", new Book("Gray's Anatomy", "Gray", "Reference", 1858, 3.0, 1));

		while (userChar != 'q') {
			System.out.println();
			l1.printMenu();
			userChar = scnr.next().charAt(0);

			if (userChar == 'l' || userChar == 'c' || userChar == 'b' || userChar == 'a' || userChar == 'r'
					|| userChar == 'y' || userChar == 'q') {
				l1.executeMenu(scnr, userChar, books);
			}

			else {
				System.out.println("Invalid Option");
			}
		}

	}

}
