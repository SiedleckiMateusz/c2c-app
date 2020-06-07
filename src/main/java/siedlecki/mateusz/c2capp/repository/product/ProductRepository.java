package siedlecki.mateusz.c2capp.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.product.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
