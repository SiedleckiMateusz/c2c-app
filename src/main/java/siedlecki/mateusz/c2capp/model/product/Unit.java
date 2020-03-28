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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Unit extends BaseEntity {

    private String name;

    private String shortName;

    @OneToMany(mappedBy = "unit")
    private List<ProductInDelivery> products = new ArrayList<>();

    public Unit(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
