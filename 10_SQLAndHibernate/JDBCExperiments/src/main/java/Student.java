import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "registration_date")
    private Date registrationDate;

    private int age;

    //родитительский класс student
    @OneToMany(mappedBy = "student")
    private List<Subscription> subscriptions;

    //родитительский класс student
    @OneToMany(mappedBy = "student")
    private List<LinkedPurchaseList> linkedPurchaseList;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<LinkedPurchaseList> getLinkedPurchaseList() {
        return linkedPurchaseList;
    }

    public void setLinkedPurchaseList(List<LinkedPurchaseList> linkedPurchaseList) {
        this.linkedPurchaseList = linkedPurchaseList;
    }
}
