package siedlecki.mateusz.c2capp.controller.mapper.product;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.product.ShowLocation;
import siedlecki.mateusz.c2capp.entity.product.LocationEntity;

@Component
public class LocationMapper {

    public ShowLocation entityToShow(LocationEntity o){
        if (o==null) return null;

        return ShowLocation.builder()
                .id(o.getId())
                .name(o.getName())
                .build();

    }
}
