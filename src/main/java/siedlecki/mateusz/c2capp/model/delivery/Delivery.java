package siedlecki.mateusz.c2capp.model.delivery;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {

    private LocalDateTime creationTime;

    @ManyToOne
    private Dealer dealer;

    @ManyToOne
    private Supplier supplier;

    private Boolean deliveryOk;

    @ManyToOne
    private Employee picker;

    private String info;


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
