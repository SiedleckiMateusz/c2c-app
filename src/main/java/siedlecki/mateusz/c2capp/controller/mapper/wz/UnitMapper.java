package siedlecki.mateusz.c2capp.controller.mapper.wz;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.wz.ShowUnit;
import siedlecki.mateusz.c2capp.entity.wz.UnitEntity;

@Component
public class UnitMapper {

    public ShowUnit entityToShow(UnitEntity o){
        if (o==null) return null;

        return ShowUnit.builder()
                .id(o.getId())
                .name(o.getName())
                .shortName(o.getShortName())
                .build();
    }
}
