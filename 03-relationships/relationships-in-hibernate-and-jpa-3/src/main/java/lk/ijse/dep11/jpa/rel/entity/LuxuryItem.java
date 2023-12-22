package lk.ijse.dep11.jpa.rel.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "luxury_item")
public class LuxuryItem implements Serializable {
    @Id
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(name = "purchase",
            joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
            inverseJoinColumns = {
                @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
                @JoinColumn(name = "supplier_id", referencedColumnName = "id"),
            })
    private Map purchaseBuyerSet;

//    @ManyToMany
//    @JoinTable(name = "purchase",
//            joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
//            inverseJoinColumns =  @JoinColumn(name = "buyer_id", referencedColumnName = "id"))
//    private List<Buyer> buyerSet;
//
//    @ManyToMany
//    @JoinTable(name = "purchase",
//            joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
//            inverseJoinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "id"))
//    private List<Supplier> supplierSet;

}
