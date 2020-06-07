package siedlecki.mateusz.c2capp.entity.delivery;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;
import siedlecki.mateusz.c2capp.entity.employee.EmployeeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class DeliveryEntity extends BaseEntity {

    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private DealerEntity dealer;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    @ManyToOne
    @JoinColumn(name = "picker_id")
    private EmployeeEntity picker;

    private String info;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery",fetch = FetchType.EAGER)
    private List<ProductInDeliveryEntity> productsInDelivery = new ArrayList<>();


    @Builder
    public DeliveryEntity(Long id, LocalDateTime created, DealerEntity dealer, SupplierEntity supplier
            , EmployeeEntity picker, String info, List<ProductInDeliveryEntity> productsInDelivery) {
        super(id);
        this.created = created;
        this.dealer = dealer;
        this.supplier = supplier;
        this.picker = picker;
        this.info = info;
        this.productsInDelivery = productsInDelivery;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + getId() +
                ", created=" + created +
                ", dealer=" + dealer +
                ", supplier=" + supplier +
                ", picker=" + picker +
                ", info='" + info + '\'' +
                ", productsInDelivery=" + productsInDelivery +
                '}';
    }
}
