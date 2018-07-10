package entity;
import javax.persistence.*;

@Entity
@Table(name= "authors")
public class Author {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name="name", length=64)
    String name;
    @Column(name="lastname", length=64)
    String lastName;

    public Author(int i, String n, String ln)
    {
        id = i;
        name = n;
        lastName = ln;
    }


}
