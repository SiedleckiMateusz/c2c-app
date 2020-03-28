package siedlecki.mateusz.c2capp.model.delivery;

import lombok.*;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.product.Product;
import siedlecki.mateusz.c2capp.model.product.Unit;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductInDelivery extends BaseEntity {

    @OneToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @Builder
    public ProductInDelivery(Product product, Float quantity, Unit unit,Delivery delivery) {
        this.product = product;
        this.quantity = quantity;
        this.unit = unit;
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "ProductInDelivery{" +
                "id=" + getId() +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unit=" + unit +
                '}';
    }
}
