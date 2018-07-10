package dataAccess;

import entity.Book;

import java.sql.ResultSet;
import java.util.ArrayList;

public class H2BookDAO extends BookDAO {

    public void create(Book book){

        try {
            H2DBController.Inquiry(String.format("INSERT INTO books (title,author_id,year) VALUES ('%s',%s,%s)",book.getTitle(),book.getIdAuthor(),book.getYear()));
            System.out.println("New book added." + book.getYear());
        }
        catch (Exception e)
        {
            System.out.println("Can't add new book to DB: " + e.toString());
        }
    }

    public void update(Book newBook){

        try {
            H2DBController.Inquiry("UPDATE books SET title = \'"+newBook.getTitle()+"\', author_id = "+newBook.getIdAuthor()+", year = \'"+newBook.getYear()+"\' WHERE id = " + newBook.getId() +";");

            System.out.println("Book updated." + newBook.getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Book book){

        try {
            H2DBController.Inquiry("DELETE FROM books\n" +
                    "WHERE id="+book.getId()+";");
            System.out.println("Book deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getAll(){
        ArrayList<Book> mass = new ArrayList<Book>();
        try {
            ResultSet rs = H2DBController.InquiryWithResult("select * from books");
            while (rs.next()) {
                mass.add(new Book(rs.getInt("id"),rs.getString("title"),rs.getInt("author_id"),rs.getString("year")));
            }
        }
        catch (Exception e){}
        return  mass;
    }

    public Book get(int id){
        Book book = null;
        try {
            ResultSet rs = H2DBController.InquiryWithResult("select from books where id = " + id);
            while (rs.next()) {
                book = new Book(rs.getInt("id"),rs.getString("title"),rs.getInt("author_id"),rs.getString("year"));
            }
        }
        catch (Exception e){}
        return  book;
    }
}
