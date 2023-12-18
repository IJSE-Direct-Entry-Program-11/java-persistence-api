package lk.ijse.dep11.app.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 20)
    private String contact;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet;

    public Customer(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}
