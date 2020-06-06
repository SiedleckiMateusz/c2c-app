package siedlecki.mateusz.c2capp.entity.wz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseProductIn;
import siedlecki.mateusz.c2capp.entity.product.Product;
import siedlecki.mateusz.c2capp.entity.product.Unit;

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
    public ProductInWz(Long id, Product product, Float quantity, Unit unit,String info,Wz wz) {
        super(id, product, quantity, unit,info);
        this.wz = wz;
    }




}
