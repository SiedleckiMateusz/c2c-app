package siedlecki.mateusz.c2capp.controller.mapper.employee;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.employee.ShowWorkPosition;
import siedlecki.mateusz.c2capp.entity.employee.WorkPositionEntity;

@Component
public class WorkPositionMapper {

    public ShowWorkPosition entityToShow(WorkPositionEntity o){
        if (o==null){
            return null;
        }

        return ShowWorkPosition.builder()
                .id(o.getId())
                .name(o.getName())
                .description(o.getDescription())
                .build();
    }
}
