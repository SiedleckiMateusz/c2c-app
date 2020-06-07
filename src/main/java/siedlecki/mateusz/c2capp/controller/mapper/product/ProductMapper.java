package siedlecki.mateusz.c2capp.controller.mapper.product;

import org.springframework.stereotype.Component;
import siedlecki.mateusz.c2capp.controller.model.product.ShowProduct;
import siedlecki.mateusz.c2capp.entity.product.ProductEntity;

import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private final LocationMapper locationMapper;
    private final ProductFlagMapper productFlagMapper;

    public ProductMapper(LocationMapper locationMapper, ProductFlagMapper productFlagMapper) {
        this.locationMapper = locationMapper;
        this.productFlagMapper = productFlagMapper;
    }

    public ShowProduct entityToShow(ProductEntity o){
        if (o==null) return null;

        return ShowProduct.builder()
                .id(o.getId())
                .name(o.getName())
                .description(o.getDescription())
                .barcode(o.getBarcode())
                .symbol(o.getSymbol())
                .pictureUrl(o.getPictureUrl())
                .locations(o.getLocations().stream()
                        .map(locationMapper::entityToShow)
                        .collect(Collectors.toList()))
                .productFlags(o.getProductFlags().stream()
                        .map(productFlagMapper::entityToShow)
                        .collect(Collectors.toList()))
                .build();
    }
}
