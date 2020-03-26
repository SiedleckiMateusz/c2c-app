package siedlecki.mateusz.c2capp.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.delivery.ProductInDelivery;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Unit extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "unit")
    private List<ProductInDelivery> products = new ArrayList<>();
}
