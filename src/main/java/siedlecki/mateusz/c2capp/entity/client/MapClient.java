package siedlecki.mateusz.c2capp.entity.client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MapClient {

    private Long id;
    private String name;
    private String cordX;
    private String cordY;

    public static MapClient getMapClientFrom(ClientEntity client){
        return new MapClient(client.getId(),client.getWarehouseName(), client.getCoordinates().getX(),client.getCoordinates().getY());
    }
}
