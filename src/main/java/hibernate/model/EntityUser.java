package hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "User", schema = "test")
public class EntityUser {
    private int id;
    private String name;
    private int age;
    private boolean isisAdmin;
    private Timestamp createDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>25) name = name.substring(0,25);
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (String.valueOf(age).isEmpty()|| age<0 ) age = 0;
        this.age = age;
    }

    @Basic
    @Column(name = "isAdmin", nullable = false)
    public boolean isIsisAdmin() {
        return isisAdmin;
    }

    public void setIsisAdmin(boolean isisAdmin) {
        this.isisAdmin = isisAdmin;
    }

    @Basic
    @Column(name = "createDate")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        if  (createDate==null || ! (createDate instanceof Timestamp)) this.createDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
        else {
            this.createDate = createDate;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityUser that = (EntityUser) o;

        if (id != that.id) return false;
        if (age != that.age) return false;
        if (isisAdmin != that.isisAdmin) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isisAdmin ? 1 : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
