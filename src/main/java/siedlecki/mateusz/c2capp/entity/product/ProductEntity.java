package siedlecki.mateusz.c2capp.entity.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import siedlecki.mateusz.c2capp.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductEntity extends BaseEntity {

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "product_flags"
            , joinColumns = @JoinColumn(name = "product_id")
            , inverseJoinColumns = @JoinColumn(name = "flag_id"))
    private List<ProductFlagEntity> productFlags = new ArrayList<>();

    private String symbol;

    private String barcode;

    private String pictureUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "product_locations",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<LocationEntity> locations = new ArrayList<>();

    @Builder
    public ProductEntity(Long id, String name, String description, List<ProductFlagEntity> productFlags, String symbol, String barcode,
                         String pictureUrl, List<LocationEntity> locations) {
        super(id);
        this.name = name;
        this.description = description;
        this.productFlags = productFlags;
        this.symbol = symbol;
        this.barcode = barcode;
        this.pictureUrl = pictureUrl;
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productFlags=" + productFlags +
                ", symbol='" + symbol + '\'' +
                ", barcode='" + barcode + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", locations=" + locations +
                '}';
    }
}
