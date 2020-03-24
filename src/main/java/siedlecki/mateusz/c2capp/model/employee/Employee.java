package siedlecki.mateusz.c2capp.model.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;
import siedlecki.mateusz.c2capp.model.delivery.Delivery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private String login;

    private String password;

    private String email;

    private String phoneNumber;

    @ManyToOne()
    private WorkPosition workPosition;

    @ManyToOne()
    private Department department;

    @OneToMany(mappedBy = "delivery")
    private Set<Delivery> deliveries;


    @Builder
    public Employee(Long id, String firstName, String lastName, String login, String password, String email, String phoneNumber,
                    WorkPosition workPosition, Department department) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.workPosition = workPosition;
        this.department = department;
    }
}
