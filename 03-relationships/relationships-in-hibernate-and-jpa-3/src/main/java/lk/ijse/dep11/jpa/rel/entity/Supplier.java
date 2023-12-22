package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
@SecondaryTable(name = "purchase",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "supplier_id", referencedColumnName = "id"))
public class Supplier {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;

}
