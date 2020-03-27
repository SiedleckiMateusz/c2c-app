package siedlecki.mateusz.c2capp.model.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coordinates extends BaseEntity {

    private String x;
    private String y;

    @OneToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    public Coordinates(String x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "'" + x + '\'' +
                ", '" + y + '\'';
    }
}
