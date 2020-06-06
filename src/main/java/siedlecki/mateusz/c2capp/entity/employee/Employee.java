package siedlecki.mateusz.c2capp.entity.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;
import siedlecki.mateusz.c2capp.entity.delivery.Delivery;
import siedlecki.mateusz.c2capp.entity.wz.Wz;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "work_position_id")
    private WorkPosition workPosition;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "picker")
    private List<Delivery> deliveries = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Wz> wz = new ArrayList<>();

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


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", workPosition=" + workPosition +
                ", department=" + department +
                '}';
    }
}
