package entity;
import javax.persistence.*;

@Entity
@Table(name= "authors")
public class Author {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name", length=64)
    private String name;
    @Column(name="lastname", length=64)
    private String lastName;

    public Author(int i, String n, String ln)
    {
        id = i;
        name = n;
        lastName = ln;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}
