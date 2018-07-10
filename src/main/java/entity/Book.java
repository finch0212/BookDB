package entity;

import javax.persistence.*;

@Entity
@Table(name= "books")
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name="title")
    String title;
    @Column(name="author_id")
    int idAutor;
    @Column(name="year")
    String year;

    public Book(int i, String t, int ia, String y)
        {
            id = i;
            title = t;
            idAutor = ia;
            year = y;
        }

}

