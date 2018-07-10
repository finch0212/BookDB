package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2DBController {

    public static Connection connection;
    public static Statement statement;
    public int idACount;
    public int idBCount;

    public static void Connect()
    {
        try {
            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:file:~/test",
                    "sa", "");
            statement = connection.createStatement();
            //CreateDB();

        }
        catch (Exception e)
        {
            System.out.println("Can't connect to DB: " + e.toString());
        }

    }

    public static ResultSet InquiryWithResult(String str)
    {
        try {
            ResultSet rs = statement.executeQuery(str);
            return rs;
        }
        catch (Exception e)
        {
            System.out.println("Can't handle inquiry: " + e.toString());
        }
        return  null;
    }

    public static void Inquiry(String str) throws  Exception {

        statement.execute(str);
    }


    public static void CreateDB()
    {
        try {
            statement.execute("CREATE TABLE authors\n" +
                    "(\n" +
                    "id integer NOT NULL AUTO_INCREMENT,\n" +
                    "name varchar(255),\n" +
                    "lastname varchar(255),\n" +
                    "CONSTRAINT PK_authors PRIMARY KEY (id)\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE books\n" +
                    "(\n" +
                    "id integer NOT NULL AUTO_INCREMENT,\n" +
                    "title varchar(255) NOT NULL,\n" +
                    "author_id integer NOT NULL,\n" +
                    "year integer,\n" +
                    "CONSTRAINT PK_books PRIMARY KEY (id)\n" +
                    ");\n" +
                    "\n" +
                    "ALTER TABLE books ADD CONSTRAINT FK_books_\n" +
                    "FOREIGN KEY (author_id) REFERENCES authors (id) ON DELETE CASCADE;");

        }
        catch (Exception e)
        {
            System.out.println("Can't create DB: " + e.toString());
        }
    }

    /*public static int GetAuthorsMaxId()
    {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM authors ORDER BY ID DESC LIMIT 1");
            rs.next();
            if (!rs.next()) {
                return -1;
            }
            return rs.getInt("id");
        }
        catch (Exception e)
        {
            System.out.println("Can't get Authors Max Id DB: " + e.toString());
        }
        return 0;
    }

    public static int GetBooksMaxId()
    {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM books ORDER BY ID DESC LIMIT 1");
            rs.next();
            return  rs.getInt("id");
        } catch (Exception e) {
            System.out.println("Can't get Books Max Id DB: " + e.toString());
        }
        return 0;
    }*/

}
