package siedlecki.mateusz.c2capp.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductFlag extends BaseEntity {

    private String name;

    @Override
    public String toString() {
        return "ProductFlag{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
