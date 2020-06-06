package siedlecki.mateusz.c2capp.entity.wz;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;
import siedlecki.mateusz.c2capp.entity.employee.Employee;

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
    private ClientEntity client;

    private String info;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wz", fetch = FetchType.EAGER)
    private List<ProductInWz> productsInWz = new ArrayList<>();

    @Builder
    public Wz(Long id, LocalDate created, List<ProductInWz> productsInWz
            , ClientEntity client, String info, Employee employee) {
        super(id);
        this.created = created;
        this.client = client;
        this.info = info;
        this.productsInWz = productsInWz;
        this.employee = employee;
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
