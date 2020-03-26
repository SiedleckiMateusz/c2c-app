package siedlecki.mateusz.c2capp.model.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

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
public class Dealer extends BaseEntity {

    private String name;

    private String nip;

    @OneToMany(mappedBy = "dealer")
    private List<Delivery> deliveries = new ArrayList<>();
}
