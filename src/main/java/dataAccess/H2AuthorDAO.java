package dataAccess;

import entity.Author;
import entity.Book;

import java.sql.ResultSet;
import java.util.ArrayList;

public class H2AuthorDAO extends AuthorDAO{

    public void create(Author author){

        try {
            H2DBController.Inquiry("INSERT INTO authors (name,lastname) VALUES (\'" + author.getName() + "\',\'" + author.getLastName() + "\')");
            System.out.println("New author added.");
        }
        catch (Exception e)
        {
            System.out.println("Can't add new author to DB: " + e.toString());
        }
    }

    public void update(Author newAuthor){

        try {
            H2DBController.Inquiry("UPDATE authors SET name = \'"+newAuthor.getName()+"\', lastname = \'"+newAuthor.getLastName()+"\' WHERE id = " + newAuthor.getId() +";");
            System.out.println("Author updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Author author){

        try {
            H2DBController.Inquiry("DELETE FROM authors\n" +
                    "WHERE id="+author.getId()+";");
            System.out.println("Author deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Author> getAll(){
        ArrayList<Author> mass = new ArrayList<Author>();
        try {
            ResultSet rs = H2DBController.InquiryWithResult("select * from authors");
            while (rs.next()) {
                mass.add(new Author(rs.getInt("id"),rs.getString("name"),rs.getString("lastname")));
            }
        }
        catch (Exception e){}
        return  mass;
    }

    public Author get(int id){
        Author author = null;
        try {
            ResultSet rs = H2DBController.InquiryWithResult("select * from authors");
            while (rs.next()) {
                author = new Author(rs.getInt("id"),rs.getString("name"),rs.getString("lastname"));
            }
        }
        catch (Exception e){}
        return  author;
    }


}
