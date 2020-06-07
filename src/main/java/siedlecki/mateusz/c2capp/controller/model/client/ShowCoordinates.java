package siedlecki.mateusz.c2capp.controller.model.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ShowCoordinates {

    private Long id;
    private String x;
    private String y;
}
