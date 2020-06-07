package siedlecki.mateusz.c2capp.controller.mapper.wz;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.mapper.client.ClientMapper;
import siedlecki.mateusz.c2capp.controller.mapper.employee.EmployeeMapper;
import siedlecki.mateusz.c2capp.controller.model.wz.ShowWz;
import siedlecki.mateusz.c2capp.entity.wz.WzEntity;

import java.util.stream.Collectors;

@Component
public class WzMapper {

    private final EmployeeMapper employeeMapper;
    private final ProductInWzMapper productInWzMapper;
    private final ClientMapper clientMapper;

    public WzMapper(EmployeeMapper employeeMapper
            , ProductInWzMapper productInWzMapper, ClientMapper clientMapper) {
        this.employeeMapper = employeeMapper;
        this.productInWzMapper = productInWzMapper;
        this.clientMapper = clientMapper;
    }

    public ShowWz entityToShow(WzEntity o){
        if (o==null) return null;

        return ShowWz.builder()
                .id(o.getId())
                .created(o.getCreated())
                .info(o.getInfo())
                .client(clientMapper.entityToShow(o.getClient()))
                .employee(employeeMapper.entityToShow(o.getEmployee()))
                .productsInWz(o.getProductsInWz().stream()
                        .map(productInWzMapper::entityToShow)
                        .collect(Collectors.toList()))
                .build();
    }
}
