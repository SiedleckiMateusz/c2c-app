package siedlecki.mateusz.c2capp.entity.delivery;

import lombok.*;
import siedlecki.mateusz.c2capp.entity.BaseProductIn;
import siedlecki.mateusz.c2capp.entity.product.ProductEntity;
import siedlecki.mateusz.c2capp.entity.wz.UnitEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductInDeliveryEntity extends BaseProductIn {

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity delivery;

    @Builder
    public ProductInDeliveryEntity(Long id, ProductEntity product, Float quantity, UnitEntity unit, DeliveryEntity delivery, String info) {
        super(id,product,quantity,unit,info);
        this.delivery = delivery;
    }

}
