package siedlecki.mateusz.c2capp.model.client;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Client extends BaseEntity {

    private String warehouseName;

    private String realName;

    private String nip;

    private String address;

    @OneToOne(mappedBy = "client")
    private Coordinates coordinates;

    private String info;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Builder
    public Client(Long id, String warehouseName, String realName, String nip, String address, Coordinates coordinates, String info, Route route) {
        super(id);
        this.warehouseName = warehouseName;
        this.realName = realName;
        this.nip = nip;
        this.address = address;
        this.coordinates = coordinates;
        this.info = info;
        this.route = route;
    }
}
