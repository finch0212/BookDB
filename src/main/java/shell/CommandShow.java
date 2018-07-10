package shell;

import entity.Author;
import entity.Book;
import services.BookService;

import java.util.ArrayList;

public class CommandShow extends Command {

    @Override
    public void Execute(String[] args) {

        if(args[0].equals("books")){

            ArrayList<Book> mass = BookService.getInstance().getBooks();
            System.out.println("Books: ");
            for (Book b: mass
                 ) {
                System.out.println(b.getId() + ": Title: " + b.getTitle() + " , Author:" + b.getIdAuthor() + " , Year:" + b.getYear());
            }
        }
        else if(args[0].equals("authors")){

            ArrayList<Author> mass = BookService.getInstance().getAuthors();
            System.out.println("Authors: ");
            for (Author a: mass
                 ) {
                System.out.println(a.getId() + ": " + a.getName() + " " + a.getLastName());
            }
        }
        else if(args[0].equals("all")){

            ArrayList<Book> mass = BookService.getInstance().getBooks();
            System.out.println("Books: ");
            for (Book b: mass
                    ) {
                System.out.println(b.getId() + ": Title: " + b.getTitle() + " , Author:" + b.getIdAuthor() + " , Year:" + b.getYear());
            }
            ArrayList<Author> mass2 = BookService.getInstance().getAuthors();
            System.out.println("Authors: ");
            for (Author a: mass2
                    ) {
                System.out.println(a.getId() + ": " + a.getName() + " " + a.getLastName());
            }
        }
    }
}
