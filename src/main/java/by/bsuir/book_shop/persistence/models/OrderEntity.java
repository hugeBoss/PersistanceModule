package by.bsuir.book_shop.persistence.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Huge Boss on 27.10.2016.
 */
@Entity
@Table(name = "order_t", schema = "booksdb", catalog = "")
public class OrderEntity extends Model{

    private static final long serialVersionUID = -6829379632375928517L;

    @ManyToMany
    @JoinTable(name = "author_has_book",
            joinColumns =
            @JoinColumn(name = "author_id"),
            inverseJoinColumns =
            @JoinColumn(name = "book_id")
    )
    private Set<BookEntity> books;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    public UserEntity getUser(UserEntity byId) {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public OrderEntity(){


    }

    public UserEntity getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.getId() * 31;
        return result;
    }
}
