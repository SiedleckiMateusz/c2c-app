package siedlecki.mateusz.c2capp.model.wz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.BaseProductIn;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.model.product.Product;
import siedlecki.mateusz.c2capp.model.product.Unit;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Wz extends BaseEntity {

    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String info;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wz", fetch = FetchType.EAGER)
    private List<ProductInWz> productsInWz = new ArrayList<>();

    @Builder
    public Wz(Long id, LocalDate created, List<ProductInWz> productsInWz
            , Client client, String info) {
        super(id);
        this.created = created;
        this.client = client;
        this.info = info;
        this.productsInWz = productsInWz;
    }

    @Override
    public String toString() {
        return "Wz{" +
                "id=" + getId() +
                ", created=" + created +
                ", client=" + client +
                ", info='" + info + '\'' +
                ", productsInWz=" + productsInWz +
                '}';
    }
}
