package siedlecki.mateusz.c2capp.model.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import siedlecki.mateusz.c2capp.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {

    private String name;

    private String description;

    @ManyToOne
    private ProductGroup productGroup;

    private String symbol;

    private String barcode;

    private String pictureUrl;

    @Builder
    public Product(Long id, String name, String description, ProductGroup productGroup, String symbol, String barcode, String pictureUrl) {
        super(id);
        this.name = name;
        this.description = description;
        this.productGroup = productGroup;
        this.symbol = symbol;
        this.barcode = barcode;
        this.pictureUrl = pictureUrl;
    }
}
