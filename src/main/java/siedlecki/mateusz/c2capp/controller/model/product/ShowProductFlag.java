package siedlecki.mateusz.c2capp.controller.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowProductFlag {

    private Long id;
    private String name;
}
