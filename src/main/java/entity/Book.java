package entity;

import javax.persistence.*;

@Entity
@Table(name= "books")
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="author_id")
    private int idAuthor;
    @Column(name="year")
    private String year;

    public Book(int i, String t, int ia, String y) {
            id = i;
            title = t;
            idAuthor = ia;
            year = y;
    }

    public int getId() {
        return id;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}

