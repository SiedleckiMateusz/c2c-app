package siedlecki.mateusz.c2capp.entity.wz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseProductIn;
import siedlecki.mateusz.c2capp.entity.product.ProductEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductInWzEntity extends BaseProductIn {

    @ManyToOne
    @JoinColumn(name = "wz_id")
    private WzEntity wz;

    @Builder
    public ProductInWzEntity(Long id, ProductEntity product, Float quantity, UnitEntity unit, String info, WzEntity wz) {
        super(id, product, quantity, unit,info);
        this.wz = wz;
    }




}
