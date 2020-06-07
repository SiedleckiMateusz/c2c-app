package siedlecki.mateusz.c2capp.entity.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierEntity extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<DeliveryEntity> deliveries = new ArrayList<>();

    public SupplierEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
