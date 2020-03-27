package siedlecki.mateusz.c2capp.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkPosition extends BaseEntity {

    @NotNull
    private String name;

    private String description;

    @OneToMany(mappedBy = "workPosition")
    private List<Employee> employees = new ArrayList<>();

    public WorkPosition(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "WorkPosition{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
