package Tut10.ex2;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class BookDemo {
    public static void main(String[] args) throws IllegalClassFormatException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input author: ");
            String author = scanner.nextLine();
            System.out.print("Input title: ");
            String title = scanner.nextLine();
            System.out.print("Input price: ");
            double price = Double.valueOf(scanner.nextLine());
            Book book = new Book(author, title, price);
            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);
            Method[] bookDeclaredMethods = Book.class.getDeclaredMethods();
            Method[] goldenBookDeclaredMethods = GoldenEditionBook.class.getDeclaredMethods();
            if (goldenBookDeclaredMethods.length > 1) {
                throw new IllegalClassFormatException("Code duplication in GoldenEditionBook!");
            }
            System.out.println("\n" + book.toString());
            System.out.println(goldenEditionBook.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
