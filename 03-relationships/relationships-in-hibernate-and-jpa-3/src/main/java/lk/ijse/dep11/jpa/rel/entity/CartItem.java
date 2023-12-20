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
@Table(name = "cart_item")
public class CartItem implements Serializable {
    @EmbeddedId
    @AttributeOverride(name = "cartId", column = @Column(name = "cart_id"))
    @AttributeOverride(name = "itemCode", column = @Column(name = "item_code", length = 50))
    private CartItemPK cartItemPK;

    @Column(nullable = false)
    private int qty;

    @ManyToOne
    @MapsId("cartId")
    //@JoinColumn(name = "cart_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Cart cart;

    @ManyToOne
    @MapsId("itemCode")
    //@JoinColumn(name = "item_code", referencedColumnName = "code",insertable = false, updatable = false)
    private Item item;

    public CartItem(int cartId, String itemCode, int qty) {
        this.cartItemPK = new CartItemPK(cartId, itemCode);
        this.qty = qty;
    }
}
