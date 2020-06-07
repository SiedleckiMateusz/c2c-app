package siedlecki.mateusz.c2capp.controller.model.wz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import siedlecki.mateusz.c2capp.controller.model.client.ShowClient;
import siedlecki.mateusz.c2capp.controller.model.employee.ShowEmployee;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowWz {

    private Long id;
    private LocalDate created;
    private ShowClient client;
    private String info;
    private ShowEmployee employee;
    private List<ShowProductInWz> productsInWz;

}
