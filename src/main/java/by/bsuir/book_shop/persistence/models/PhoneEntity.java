package by.bsuir.book_shop.persistence.models;

import javax.persistence.*;

/**
 * Created by Huge Boss on 27.10.2016.
 */
@Entity
@Table(name = "phone", schema = "booksdb", catalog = "")
public class PhoneEntity extends Model {

    private static final long serialVersionUID = 1185826102950480991L;

    public PhoneEntity(String phone, String typeOfPhone) {
        this.phone = phone;
        this.typeOfPhone = typeOfPhone;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    private String phone;

    @Basic
    @Column(name = "type_of_phone", nullable = false, length = 45)
    private String typeOfPhone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public PhoneEntity(){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getTypeOfPhone() {
        return typeOfPhone;
    }

    public void setTypeOfPhone(String typeOfPhone) {
        this.typeOfPhone = typeOfPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneEntity that = (PhoneEntity) o;

        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (typeOfPhone != null ? !typeOfPhone.equals(that.typeOfPhone) : that.typeOfPhone != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (typeOfPhone != null ? typeOfPhone.hashCode() : 0);
        result = 31 * super.getId();
        return result;
    }
}
