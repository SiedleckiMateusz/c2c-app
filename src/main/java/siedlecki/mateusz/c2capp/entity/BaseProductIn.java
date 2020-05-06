package siedlecki.mateusz.c2capp.entity;

import lombok.*;
import siedlecki.mateusz.c2capp.entity.product.Product;
import siedlecki.mateusz.c2capp.entity.product.Unit;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseProductIn extends BaseEntity {

    @OneToOne
    private Product product;

    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;



    public BaseProductIn(Long id,Product product, Float quantity, Unit unit) {
        super(id);
        this.product = product;
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unit=" + unit +
                '}';
    }
}
