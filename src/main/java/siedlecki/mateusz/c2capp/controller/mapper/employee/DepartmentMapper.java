package siedlecki.mateusz.c2capp.controller.mapper.employee;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.employee.ShowDepartment;
import siedlecki.mateusz.c2capp.entity.employee.DepartmentEntity;

@Component
public class DepartmentMapper {

    public ShowDepartment entityToShow(DepartmentEntity o){
        if (o==null){
            return null;
        }

        return ShowDepartment.builder()
                .id(o.getId())
                .name(o.getName())
                .build();
    }
}
