package bookManagement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookManagementTest {
       @Mock
       private BookDao bookDao;
       @InjectMocks
       private BookManager bookManager;
       @BeforeEach
       void setup() {
    	   MockitoAnnotations.openMocks(this);
       }
       
       @Test
       void testGetAllBooks() {
           List<Book> mockBook = Arrays.asList(
               new Book(1,"Effective Java","Joshua Bloch",45.50),
               new Book(2,"Clean Code","Robert C. Martin",40.00)
           );

           when(bookDao.getAllBooks()).thenReturn(mockBook);

           List<Book> books = bookManager.getAllBooks();

           assertEquals(2, books.size());
           
       }
       @Test
       void testAddBook() {
    	   
       }

}
