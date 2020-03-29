package siedlecki.mateusz.c2capp.model.delivery;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.employee.Employee;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {

    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private Boolean deliveryOk;

    @ManyToOne
    @JoinColumn(name = "picker_id")
    private Employee picker;

    private String info;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery",fetch = FetchType.EAGER)
    private List<ProductInDelivery> productsInDelivery = new ArrayList<>();


    @Builder
    public Delivery(Long id, LocalDateTime creationTime, Dealer dealer, Supplier supplier, Boolean deliveryOk, Employee picker, String info
            , List<ProductInDelivery> productsInDelivery) {
        super(id);
        this.creationTime = creationTime;
        this.dealer = dealer;
        this.supplier = supplier;
        this.deliveryOk = deliveryOk;
        this.picker = picker;
        this.info = info;
        this.productsInDelivery = productsInDelivery;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + getId() +
                ", creationTime=" + creationTime +
                ", dealer=" + dealer +
                ", supplier=" + supplier +
                ", deliveryOk=" + deliveryOk +
                ", picker=" + picker +
                ", info='" + info + '\'' +
                ", productsInDelivery=" + productsInDelivery +
                '}';
    }
}
