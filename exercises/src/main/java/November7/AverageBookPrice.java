package November7;

import java.util.ArrayList;

public class AverageBookPrice {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(100, "author", "Title"));
        books.add(new Book(200, "author1", "Title1"));
        books.add(new Book(300, "author2", "Title2"));

        books.stream()
                .peek(x-> System.out.println(x.author))
                .forEach(x-> System.out.println(x.title));
    }


    private static class Book {
        double price;
        String author;
        String title;

        public Book(double price, String author, String title) {
            this.price = price;
            this.author = author;
            this.title = title;
        }
    }
}
