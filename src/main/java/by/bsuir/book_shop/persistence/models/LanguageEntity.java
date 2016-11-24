package by.bsuir.book_shop.persistence.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Huge Boss on 27.10.2016.
 */
@Entity
@Table(name = "language", schema = "booksdb", catalog = "")
public class LanguageEntity extends Model {

    private static final long serialVersionUID = 4102140525510856918L;

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    @OneToMany(mappedBy = "language")
    private Set<BookEntity> books;

    public LanguageEntity(String name) {
        this.name = name;
    }

    public LanguageEntity(){

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageEntity that = (LanguageEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
