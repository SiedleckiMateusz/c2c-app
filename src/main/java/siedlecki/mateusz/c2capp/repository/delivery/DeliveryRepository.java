package siedlecki.mateusz.c2capp.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.delivery.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
