package dataAccess;

import entity.Book;

import java.util.ArrayList;

abstract public class BookDAO {

    public abstract void create(Book book);

    public abstract void update(Book newBook);

    public abstract void remove(Book book);

    public abstract ArrayList<Book> getAll();

    public abstract Book get(int id);
}
