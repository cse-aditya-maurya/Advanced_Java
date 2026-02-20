package com.capegemini.relation.BookandPublisherBidirectionalManytoOneMapping;

public class App {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        service.createPublisherWithBooks();

        service.fetchPublisher(1L);
        service.fetchBook(1L);

        service.close();
    }
}
