package siedlecki.mateusz.c2capp.entity.wz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;
import siedlecki.mateusz.c2capp.entity.delivery.ProductInDeliveryEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UnitEntity extends BaseEntity {

    private String name;

    private String shortName;

    @OneToMany(mappedBy = "unit")
    private List<ProductInDeliveryEntity> products = new ArrayList<>();

    public UnitEntity(String name, String shortName) {
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
