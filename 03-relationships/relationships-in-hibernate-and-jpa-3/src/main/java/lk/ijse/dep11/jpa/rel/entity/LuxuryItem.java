package lk.ijse.dep11.jpa.rel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
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

    @ManyToMany
    @JoinTable(name = "purchase",
            joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
            inverseJoinColumns = {
                    @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
                    @JoinColumn(name = "supplier_id", referencedColumnName = "id"),
            })
    private Set<Buyer> buyerSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "purchase",
            joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
            inverseJoinColumns = {
                    @JoinColumn(name = "supplier_id", referencedColumnName = "id"),
                    @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
            })
    private Set<Supplier> supplierSet = new HashSet<>();

    public LuxuryItem(String code, String description, BigDecimal price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }
}