package bookManagement;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param price
	 */
	public Book(int id, String title, String author, double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public final String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public final void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public final double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public final void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
    
}
