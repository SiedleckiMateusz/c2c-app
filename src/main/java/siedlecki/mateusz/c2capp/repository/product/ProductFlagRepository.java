package siedlecki.mateusz.c2capp.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.product.ProductFlag;

public interface ProductFlagRepository extends JpaRepository<ProductFlag,Long> {
}