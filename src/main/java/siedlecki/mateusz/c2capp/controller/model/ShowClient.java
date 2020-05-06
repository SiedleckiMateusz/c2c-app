package siedlecki.mateusz.c2capp.controller.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class ShowClient {
    private Long id;

    private String warehouseName;

    private String realName;

    private String nip;

    private String address;

    private ShowCoordinates coordinates;

    private String info;

    private ShowRoute route;


}
