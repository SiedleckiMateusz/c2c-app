package siedlecki.mateusz.c2capp.controller.mapper.client;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.client.ShowRoute;
import siedlecki.mateusz.c2capp.entity.client.RouteEntity;

@Component
public class RouteMapper {

    public ShowRoute toShow(RouteEntity o){
        if (o==null){
            return null;
        }

        return ShowRoute.builder()
                .id(o.getId())
                .name(o.getName())
                .build();
    }
}
