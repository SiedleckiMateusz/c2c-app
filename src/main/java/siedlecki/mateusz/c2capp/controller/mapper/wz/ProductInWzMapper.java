package siedlecki.mateusz.c2capp.controller.mapper.wz;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.mapper.product.ProductMapper;
import siedlecki.mateusz.c2capp.controller.model.wz.ShowProductInWz;
import siedlecki.mateusz.c2capp.entity.wz.ProductInWzEntity;

@Component
public class ProductInWzMapper {

    private final ProductMapper productMapper;
    private final UnitMapper unitMapper;

    public ProductInWzMapper(ProductMapper productMapper, UnitMapper unitMapper) {
        this.productMapper = productMapper;
        this.unitMapper = unitMapper;
    }

    public ShowProductInWz entityToShow(ProductInWzEntity o){
        if (o==null) return null;

        return ShowProductInWz.builder()
                .id(o.getId())
                .product(productMapper.entityToShow(o.getProduct()))
                .info(o.getInfo())
                .quantity(o.getQuantity())
                .unit(unitMapper.entityToShow(o.getUnit()))
                .build();
    }
}
