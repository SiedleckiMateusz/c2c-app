package siedlecki.mateusz.c2capp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.product.ProductEntity;
import siedlecki.mateusz.c2capp.entity.wz.UnitEntity;

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
    private ProductEntity product;

    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitEntity unit;

    private String info;



    public BaseProductIn(Long id, ProductEntity product, Float quantity, UnitEntity unit, String info) {
        super(id);
        this.product = product;
        this.quantity = quantity;
        this.unit = unit;
        this.info = info;
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
