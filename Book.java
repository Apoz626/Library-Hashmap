
/**
 * The Book class
 * 
 * @author Anthony Positano
 *
 */
public class Book {
	private String title;
	private String author;
	private String category;
	private int year;
	private double rating;
	private int numCopies;

	/**
	 * Constructs a Book object
	 * 
	 * @param title     Title of the book
	 * @param author    Author of the book
	 * @param category  Genre of the book
	 * @param year      Year book was written
	 * @param rating    Rating of the book
	 * @param numCopies Number of copies available to check out
	 */
	public Book(String title, String author, String category, int year, double rating, int numCopies) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.year = year;
		this.rating = rating;
		this.numCopies = numCopies;
	}

	/**
	 * 
	 * @return Returns Book title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @return Returns Book author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 
	 * @return Returns Book genre
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 * @return Returns Book year written
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @return Returns Book rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * 
	 * @return Returns number of copies of the Book
	 */
	public int getCopies() {
		return numCopies;
	}

	/**
	 * 
	 * @param n Sets the copies of the Book
	 */
	public void setCopies(int n) {
		numCopies = n;
	}

}
