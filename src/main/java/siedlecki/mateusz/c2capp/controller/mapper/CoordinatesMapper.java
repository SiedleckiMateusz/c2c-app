package siedlecki.mateusz.c2capp.controller.mapper;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.ShowCoordinates;
import siedlecki.mateusz.c2capp.entity.client.CoordinatesEntity;

@Component
public class CoordinatesMapper {

    public ShowCoordinates toShow(CoordinatesEntity o){
        if (o==null){
            return null;
        }

        return ShowCoordinates.builder()
                .id(o.getId())
                .x(o.getX())
                .y(o.getY())
                .build();
    }
}
