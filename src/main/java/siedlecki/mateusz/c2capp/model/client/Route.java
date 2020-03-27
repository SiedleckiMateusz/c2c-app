package siedlecki.mateusz.c2capp.model.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Route extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "route")
    private List<Client> client = new ArrayList<>();


    @Override
    public String toString() {
        return name;
    }
}
