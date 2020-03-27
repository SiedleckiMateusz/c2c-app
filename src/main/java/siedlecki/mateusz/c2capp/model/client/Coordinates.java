package siedlecki.mateusz.c2capp.model.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coordinates extends BaseEntity {

    private String x;
    private String y;

    @OneToOne
    private Client client;

    @Override
    public String toString() {
        return "Coordinates{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
