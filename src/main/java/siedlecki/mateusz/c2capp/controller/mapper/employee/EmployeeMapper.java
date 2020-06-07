package siedlecki.mateusz.c2capp.controller.mapper.employee;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.employee.ShowEmployee;
import siedlecki.mateusz.c2capp.entity.employee.EmployeeEntity;

@Component
public class EmployeeMapper {

    private final WorkPositionMapper workPositionMapper;
    private final DepartmentMapper departmentMapper;

    public EmployeeMapper(WorkPositionMapper workPositionMapper, DepartmentMapper departmentMapper) {
        this.workPositionMapper = workPositionMapper;
        this.departmentMapper = departmentMapper;
    }

    public ShowEmployee entityToShow(EmployeeEntity o){
        if (o==null){
            return null;
        }


        return ShowEmployee.builder()
                .id(o.getId())
                .firstName(o.getFirstName())
                .lastName(o.getLastName())
                .login(o.getLogin())
                .password(o.getPassword())
                .email(o.getEmail())
                .phoneNumber(o.getPhoneNumber())
                .department(departmentMapper.entityToShow(o.getDepartment()))
                .workPosition(workPositionMapper.entityToShow(o.getWorkPosition()))
                .build();
    }
}
