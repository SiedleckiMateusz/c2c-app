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
import java.util.Set;


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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private List<ProductInDelivery> products = new ArrayList<>();


    @Builder
    public Delivery(Long id, Dealer dealer, Supplier supplier, Boolean deliveryOk, Employee picker, String info) {
        super(id);
        this.creationTime = LocalDateTime.now();
        this.dealer = dealer;
        this.supplier = supplier;
        this.deliveryOk = deliveryOk;
        this.picker = picker;
        this.info = info;
    }
}
