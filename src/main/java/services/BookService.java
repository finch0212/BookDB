package services;

import dataAccess.AuthorDAO;
import dataAccess.BookDAO;
import dataAccess.H2AuthorDAO;
import dataAccess.H2BookDAO;
import entity.Author;
import entity.Book;

import java.util.ArrayList;

public class BookService {

    private static BookService bookService;
    BookDAO bookDAO = new H2BookDAO();
    AuthorDAO authorDAO = new H2AuthorDAO();

    public static BookService getInstance(){

        if(bookService == null) bookService = new BookService();
        return bookService;
    }

    public void addBook(String[] args) {

        bookDAO.create(new Book(0,args[1],Integer.parseInt(args[2]),args[3]));
    }

    public void addAuthor(String[] args){

        authorDAO.create(new Author(0,args[1],args[2]));
    }

    public void removeBook(String[] args) {

        bookDAO.remove(new Book(Integer.parseInt(args[1]),"",0,""));
    }

    public void removeAuthor(String[] args) {

        authorDAO.remove(new Author(Integer.parseInt(args[1]),"",""));
    }

    public void updateBook(String[] args) {

        bookDAO.update(new Book(Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),args[4]));
    }

    public void updateAuthor(String[] args) {

        authorDAO.update(new Author(Integer.parseInt(args[1]),args[2],args[3]));
    }

    public ArrayList<Book> getBooks() {

        return bookDAO.getAll();

        //TODO можно дописать DVO
    }

    public ArrayList<Author> getAuthors() {

        return authorDAO.getAll();
    }


}
