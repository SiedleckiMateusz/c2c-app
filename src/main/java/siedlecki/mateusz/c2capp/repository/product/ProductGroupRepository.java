package siedlecki.mateusz.c2capp.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.product.ProductGroup;

public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {
}
