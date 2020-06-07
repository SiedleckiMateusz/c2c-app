package siedlecki.mateusz.c2capp.controller.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowProduct {

    private Long id;
    private String name;
    private String description;
    private String symbol;
    private String barcode;
    private String pictureUrl;
    private List<ShowProductFlag> productFlags;
    private List<ShowLocation> locations;
}
