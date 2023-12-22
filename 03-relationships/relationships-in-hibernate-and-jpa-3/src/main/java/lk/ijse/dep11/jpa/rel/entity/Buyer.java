package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buyer")
@SecondaryTable(name = "purchase",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "buyer_id", referencedColumnName = "id"))
public class Buyer implements Serializable {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
}
