package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.delivery.DeliveryEntity;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity,Long> {
}
