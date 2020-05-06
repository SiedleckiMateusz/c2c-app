package siedlecki.mateusz.c2capp.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
