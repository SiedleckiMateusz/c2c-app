package siedlecki.mateusz.c2capp.model.employee;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "employee")
    private Set<Employee> employees;

}
