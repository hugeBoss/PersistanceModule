package by.bsuir.book_shop.persistence.models;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by Huge Boss on 27.10.2016.
 */
@Entity
@Table(name = "book", schema = "booksdb", catalog = "")
public class BookEntity extends Model {

    private static final long serialVersionUID = 7067977920019610107L;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "price", nullable = false)
    private int price;

    public BookEntity(String name, int price, LanguageEntity language) {
        this.name = name;
        this.price = price;
        this.language = language;
    }

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<AuthorEntity> authors;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable =false)
    private LanguageEntity language;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<OrderEntity> orders;

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public BookEntity(){

    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors = authors;
    }

    public BookEntity(String name, int price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
