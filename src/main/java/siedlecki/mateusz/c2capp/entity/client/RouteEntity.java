package siedlecki.mateusz.c2capp.entity.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route")
public class RouteEntity extends BaseEntity {

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "route")
    private List<ClientEntity> clients = new ArrayList<>();

    public RouteEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Route{"+getId()+": "+name+"}";
    }
}
