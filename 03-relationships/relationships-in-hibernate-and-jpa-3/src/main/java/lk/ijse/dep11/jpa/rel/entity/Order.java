package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @Column(length = 10)
    private String id;
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinTable(name = "customer_order",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false))
    private Customer customer;

    public Order(String id, Date date) {
        this.id = id;
        this.date = date;
    }
}
