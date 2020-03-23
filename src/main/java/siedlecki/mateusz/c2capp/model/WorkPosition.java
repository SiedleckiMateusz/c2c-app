package siedlecki.mateusz.c2capp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WorkPosition extends BaseEntity {

    @NotNull
    private String name;

    private String description;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<User> users;

}
