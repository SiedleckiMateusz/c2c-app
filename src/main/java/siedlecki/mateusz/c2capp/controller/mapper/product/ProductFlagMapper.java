package siedlecki.mateusz.c2capp.controller.mapper.product;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.product.ShowProductFlag;
import siedlecki.mateusz.c2capp.entity.product.ProductFlagEntity;

@Component
public class ProductFlagMapper {

    public ShowProductFlag entityToShow(ProductFlagEntity o){
        if (o==null) return null;

        return ShowProductFlag.builder()
                .id(o.getId())
                .name(o.getName())
                .build();
    }
}
