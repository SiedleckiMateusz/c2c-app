package siedlecki.mateusz.c2capp.controller.model.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowDepartment {
    private Long id;
    private String name;
}
