package dataAccess;

import entity.Author;

import java.util.ArrayList;

abstract public class AuthorDAO {

    public abstract void create(Author author);

    public abstract void update(Author newAuthor);

    public abstract void remove(Author book);

    public abstract ArrayList<Author> getAll();

    public abstract Author get(int id);
}
