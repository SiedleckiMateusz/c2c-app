package siedlecki.mateusz.c2capp.controller.model.wz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowUnit {
    private Long id;
    private String name;
    private String shortName;
}
