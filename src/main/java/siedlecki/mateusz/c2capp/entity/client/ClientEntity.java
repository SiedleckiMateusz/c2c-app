package siedlecki.mateusz.c2capp.entity.client;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.entity.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity {

    private String warehouseName;

    private String realName;

    private String nip;

    private String address;

    private String pictureUrl;

    @OneToOne(mappedBy = "client",cascade = CascadeType.ALL)
    @JsonManagedReference
    private CoordinatesEntity coordinates;

    @Lob
    private String info;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteEntity route;

    @Builder
    public ClientEntity(Long id, String warehouseName, String realName, String nip, String address, CoordinatesEntity coordinates, String info, RouteEntity route) {
        super(id);
        this.warehouseName = warehouseName;
        this.realName = realName;
        this.nip = nip;
        this.address = address;
        this.coordinates = coordinates;
        this.info = info;
        this.route = route;
    }

    @Override
    public String toString() {
        return "Client{" +
                "warehouseName='" + warehouseName + '\'' +
                ", realName='" + realName + '\'' +
                ", nip='" + nip + '\'' +
                ", address='" + address + '\'' +
                ", coordinates=" + coordinates +
                ", info='" + info + '\'' +
                ", route=" + route +
                '}';
    }
}
