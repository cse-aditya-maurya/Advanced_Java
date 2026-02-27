package bookManagement;
import java.util.List;
public class BookManager {
     private BookDao bookDao;

	 public BookManager(BookDao bookDao) {
		
		this.bookDao = bookDao;
	 }
	 
	 public List<Book> getAllBooks(){
		 return bookDao.getAllBooks();
	 }
	 public boolean addBook(Book book) {
		 return bookDao.addBook(book);
	 }
	 
     
	
     
}
