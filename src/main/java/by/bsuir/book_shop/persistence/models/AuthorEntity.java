package by.bsuir.book_shop.persistence.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Huge Boss on 27.10.2016.
 */
@Entity
@Table(name = "author", schema = "booksdb", catalog = "")
public class AuthorEntity extends Model{

    private static final long serialVersionUID = -7392645440896374322L;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @ManyToMany
    @JoinTable(name = "author_has_book",
            joinColumns =
            @JoinColumn(name = "author_id"),
            inverseJoinColumns =
            @JoinColumn(name = "book_id")
    )
    private Set<BookEntity> books;

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AuthorEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public AuthorEntity(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
