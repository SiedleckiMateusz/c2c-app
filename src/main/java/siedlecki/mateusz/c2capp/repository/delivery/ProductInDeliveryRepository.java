package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.delivery.ProductInDelivery;

public interface ProductInDeliveryRepository extends JpaRepository<ProductInDelivery,Long> {
}
