package siedlecki.mateusz.c2capp.controller.mapper.client;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.client.ShowClient;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;

@Component
public class ClientMapper {

    private final CoordinatesMapper coordinatesMapper;
    private final RouteMapper routeMapper;

    public ClientMapper(CoordinatesMapper coordinatesMapper, RouteMapper routeMapper) {
        this.coordinatesMapper = coordinatesMapper;
        this.routeMapper = routeMapper;
    }

    public ShowClient entityToShow(ClientEntity o){
        if (o==null){
            return null;
        }

        return ShowClient.builder()
                .id(o.getId())
                .address(o.getAddress())
                .info(o.getInfo())
                .nip(o.getNip())
                .warehouseName(o.getWarehouseName())
                .realName(o.getRealName())
                .pictureUrl(o.getPictureUrl())
                .coordinates(coordinatesMapper.toShow(o.getCoordinates()))
                .route(routeMapper.toShow(o.getRoute()))
                .build();
    }

}
