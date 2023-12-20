package lk.ijse.dep11.jpa.rel.entity;

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
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 20)
    private String contact;

    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    public Customer(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}
