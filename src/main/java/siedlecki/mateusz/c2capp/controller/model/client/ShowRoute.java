package siedlecki.mateusz.c2capp.controller.model.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ShowRoute {
    private Long id;
    private String name;
}
