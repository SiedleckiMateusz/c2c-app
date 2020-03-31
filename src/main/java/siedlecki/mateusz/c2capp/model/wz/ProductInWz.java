package siedlecki.mateusz.c2capp.model.wz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseProductIn;
import siedlecki.mateusz.c2capp.model.product.Product;
import siedlecki.mateusz.c2capp.model.product.Unit;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductInWz extends BaseProductIn {


    @ManyToOne
    @JoinColumn(name = "wz_id")
    private Wz wz;

    @Builder
    public ProductInWz(Long id, Product product, Float quantity, Unit unit,Wz wz) {
        super(id, product, quantity, unit);
        this.wz = wz;
    }



}
