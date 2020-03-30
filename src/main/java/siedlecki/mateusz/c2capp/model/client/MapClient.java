package siedlecki.mateusz.c2capp.model.client;


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

    public MapClient getClientFrom(Client client){
//        MapClient mapClient = new MapClient(client.getId(),client.getWarehouseName(), client)
        return null;
    }
}
