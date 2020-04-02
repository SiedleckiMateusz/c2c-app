package siedlecki.mateusz.c2capp.model.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Route extends BaseEntity {

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "route")
    private List<Client> clients = new ArrayList<>();

    public Route(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Route{"+name+"}";
    }
}
