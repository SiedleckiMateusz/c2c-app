package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.delivery.ProductInDeliveryEntity;

public interface ProductInDeliveryRepository extends JpaRepository<ProductInDeliveryEntity,Long> {
}
