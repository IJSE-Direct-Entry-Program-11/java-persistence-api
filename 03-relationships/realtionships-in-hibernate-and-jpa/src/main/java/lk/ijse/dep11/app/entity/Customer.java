package lk.ijse.dep11.app.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @Column(length = 10)
    private String id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 450)
    private String address;

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet;

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private Set<Contact> contactSet;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addOrder(Order order){
        orderSet.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order){
        throw new RuntimeException("Unsupported Operation");
    }

    public void addContact(Contact contact){
        contactSet.add(contact);
        contact.setCustomer(this);
    }

    public void removeContact(Contact contact){
        throw new RuntimeException("Unsupported Operation");
    }

}
