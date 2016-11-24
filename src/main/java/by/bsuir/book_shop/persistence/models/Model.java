package by.bsuir.book_shop.persistence.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Huge Boss on 02.11.2016.
 */
@MappedSuperclass
public abstract class Model implements Serializable {

    private static final long serialVersionUID = -8578025537838502396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model(){


    }

}
