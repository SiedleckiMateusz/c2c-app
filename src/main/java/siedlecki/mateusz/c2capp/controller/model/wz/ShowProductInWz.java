package siedlecki.mateusz.c2capp.controller.model.wz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import siedlecki.mateusz.c2capp.controller.model.product.ShowProduct;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowProductInWz {

    private Long id;
    private ShowProduct product;
    private Float quantity;
    private ShowUnit unit;
    private String info;
}
