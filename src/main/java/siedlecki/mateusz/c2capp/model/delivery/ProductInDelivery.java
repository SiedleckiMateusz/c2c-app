package siedlecki.mateusz.c2capp.model.delivery;

import lombok.*;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.BaseProductIn;
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
public class ProductInDelivery extends BaseProductIn {

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Builder
    public ProductInDelivery(Long id, Product product, Float quantity, Unit unit,Delivery delivery) {
        super(id,product,quantity,unit);
        this.delivery = delivery;
    }

}
